// pages/operation/operation.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    areaId:undefined,
    areaName:'',
    priority:'',
    findUrl:'http://localhost:8080/small/superadmin/area/find',
    createUrl:'http://localhost:8080/small/superadmin/area/create',
    updateUrl:'http://localhost:8080/small/superadmin/area/update'
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    // 页面初始化 options 为页面跳转所带来的参数
    this.setData({
      areaId: options.areaId
    });
    if (options.areaId == undefined){
      return;
    }
    wx.request({
      url: that.data.findUrl,
      method:'GET',
      data: { "areaId": options.areaId},
      success:function(res){
        var area = res.data.data.area;
        if(area == undefined){
          var toastText = '获取数据失败'+res.data.errMsg;
          wx.showToast({
            title: toastText,
            icon: '',
            duration: 2000
          });
        }else{
          that.setData({
            areaName: area.areaName,
            priority: area.priority
          })
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
  
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
  
  },

  formSubmit: function(e){
    var that = this;
    var formData = e.detail.value;
    var url = that.data.createUrl;
    if (that.data.areaId != undefined){
      formData.areaId = that.data.areaId;
      url = that.data.updateUrl;
    }
    wx.request({
      url: url,
      method:'POST',
      data:JSON.stringify(formData),
      header:{
        'Content-Type':'application/json'
      },
      success:function(res){
        var result = res.data.success;
        var toastText = '操作成功！';
        if (result != true) {
          toastText = '操作失败'+res.data.errMsg;
        }
        wx.showToast({
          title: toastText,
          icon: '',
          duration: 2000
        });
        if (that.data.areaId == undefined){
          wx.redirectTo({
            url: '../list/list',
          })
        }
        wx.redirectTo({
          url: '../list/list',
        })
      }
    })
  }
})