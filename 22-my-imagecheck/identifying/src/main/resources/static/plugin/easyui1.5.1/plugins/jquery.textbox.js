/**
 * jQuery EasyUI 1.5.1
 * 
 * Copyright (c) 2009-2016 www.jeasyui.com. All rights reserved.
 *
 * Licensed under the freeware license: http://www.jeasyui.com/license_freeware.php
 * To use it on other terms please contact us: info@jeasyui.com
 *
 */
(function($){
var _1=0;
function _2(_3){
$(_3).addClass("textbox-f").hide();
var _4=$("<span class=\"textbox\">"+"<input class=\"textbox-text\" autocomplete=\"off\">"+"<input type=\"hidden\" class=\"textbox-value\">"+"</span>").insertAfter(_3);
var _5=$(_3).attr("name");
if(_5){
_4.find("input.textbox-value").attr("name",_5);
$(_3).removeAttr("name").attr("textboxName",_5);
}
return _4;
};
function _6(_7){
var _8=$.data(_7,"textbox");
var _9=_8.options;
var tb=_8.textbox;
var _a="_easyui_textbox_input"+(++_1);
tb.addClass(_9.cls);
tb.find(".textbox-text").remove();
if(_9.multiline){
$("<textarea id=\""+_a+"\" class=\"textbox-text\" autocomplete=\"off\"></textarea>").prependTo(tb);
}else{
$("<input id=\""+_a+"\" type=\""+_9.type+"\" class=\"textbox-text\" autocomplete=\"off\">").prependTo(tb);
}
$("#"+_a).attr("tabindex",$(_7).attr("tabindex")||"").css("text-align",_7.style.textAlign||"");
tb.find(".textbox-addon").remove();
var bb=_9.icons?$.extend(true,[],_9.icons):[];
if(_9.iconCls){
bb.push({iconCls:_9.iconCls,disabled:true});
}
if(bb.length){
var bc=$("<span class=\"textbox-addon\"></span>").prependTo(tb);
bc.addClass("textbox-addon-"+_9.iconAlign);
for(var i=0;i<bb.length;i++){
bc.append("<a href=\"javascript:;\" class=\"textbox-icon "+bb[i].iconCls+"\" icon-index=\""+i+"\" tabindex=\"-1\"></a>");
}
}
tb.find(".textbox-button").remove();
if(_9.buttonText||_9.buttonIcon){
var _b=$("<a href=\"javascript:;\" class=\"textbox-button\"></a>").prependTo(tb);
_b.addClass("textbox-button-"+_9.buttonAlign).linkbutton({text:_9.buttonText,iconCls:_9.buttonIcon,onClick:function(){
var t=$(this).parent().prev();
t.textbox("options").onClickButton.call(t[0]);
}});
}
if(_9.label){
if(typeof _9.label=="object"){
_8.label=$(_9.label);
_8.label.attr("for",_a);
}else{
$(_8.label).remove();
_8.label=$("<label class=\"textbox-label\"></label>").html(_9.label);
_8.label.css("textAlign",_9.labelAlign).attr("for",_a);
if(_9.labelPosition=="after"){
_8.label.insertAfter(tb);
}else{
_8.label.insertBefore(_7);
}
_8.label.removeClass("textbox-label-left textbox-label-right textbox-label-top");
_8.label.addClass("textbox-label-"+_9.labelPosition);
}
}else{
$(_8.label).remove();
}
_c(_7);
_d(_7,_9.disabled);
_e(_7,_9.readonly);
};
function _f(_10){
var tb=$.data(_10,"textbox").textbox;
tb.find(".textbox-text").validatebox("destroy");
tb.remove();
$(_10).remove();
};
function _11(_12,_13){
var _14=$.data(_12,"textbox");
var _15=_14.options;
var tb=_14.textbox;
var _16=tb.parent();
if(_13){
if(typeof _13=="object"){
$.extend(_15,_13);
}else{
_15.width=_13;
}
}
if(isNaN(parseInt(_15.width))){
var c=$(_12).clone();
c.css("visibility","hidden");
c.insertAfter(_12);
_15.width=c.outerWidth();
c.remove();
}
var _17=tb.is(":visible");
if(!_17){
tb.appendTo("body");
}
var _18=tb.find(".textbox-text");
var btn=tb.find(".textbox-button");
var _19=tb.find(".textbox-addon");
var _1a=_19.find(".textbox-icon");
if(_15.height=="auto"){
_18.css({margin:"",paddingTop:"",paddingBottom:"",height:"",lineHeight:""});
}
tb._size(_15,_16);
if(_15.label&&_15.labelPosition){
if(_15.labelPosition=="top"){
_14.label._size({width:_15.labelWidth=="auto"?tb.outerWidth():_15.labelWidth},tb);
if(_15.height!="auto"){
tb._size("height",tb.outerHeight()-_14.label.outerHeight());
}
}else{
_14.label._size({width:_15.labelWidth,height:tb.outerHeight()},tb);
if(!_15.multiline){
_14.label.css("lineHeight",_14.label.height()+"px");
}
tb._size("width",tb.outerWidth()-_14.label.outerWidth());
}
}
if(_15.buttonAlign=="left"||_15.buttonAlign=="right"){
btn.linkbutton("resize",{height:tb.height()});
}else{
btn.linkbutton("resize",{width:"100%"});
}
var _1b=tb.width()-_1a.length*_15.iconWidth-_1c("left")-_1c("right");
var _1d=_15.height=="auto"?_18.outerHeight():(tb.height()-_1c("top")-_1c("bottom"));
_19.css(_15.iconAlign,_1c(_15.iconAlign)+"px");
_19.css("top",_1c("top")+"px");
_1a.css({width:_15.iconWidth+"px",height:_1d+"px"});
_18.css({paddingLeft:(_12.style.paddingLeft||""),paddingRight:(_12.style.paddingRight||""),marginLeft:_1e("left"),marginRight:_1e("right"),marginTop:_1c("top"),marginBottom:_1c("bottom")});
if(_15.multiline){
_18.css({paddingTop:(_12.style.paddingTop||""),paddingBottom:(_12.style.paddingBottom||"")});
_18._outerHeight(_1d);
}else{
_18.css({paddingTop:0,paddingBottom:0,height:_1d+"px",lineHeight:_1d+"px"});
}
_18._outerWidth(_1b);
_15.onResizing.call(_12,_15.width,_15.height);
if(!_17){
tb.insertAfter(_12);
}
_15.onResize.call(_12,_15.width,_15.height);
function _1e(_1f){
return (_15.iconAlign==_1f?_19._outerWidth():0)+_1c(_1f);
};
function _1c(_20){
var w=0;
btn.filter(".textbox-button-"+_20).each(function(){
if(_20=="left"||_20=="right"){
w+=$(this).outerWidth();
}else{
w+=$(this).outerHeight();
}
});
return w;
};
};
function _c(_21){
var _22=$(_21).textbox("options");
var _23=$(_21).textbox("textbox");
_23.validatebox($.extend({},_22,{deltaX:function(_24){
return $(_21).textbox("getTipX",_24);
},deltaY:function(_25){
return $(_21).textbox("getTipY",_25);
},onBeforeValidate:function(){
_22.onBeforeValidate.call(_21);
var box=$(this);
if(!box.is(":focus")){
if(box.val()!==_22.value){
_22.oldInputValue=box.val();
box.val(_22.value);
}
}
},onValidate:function(_26){
var box=$(this);
if(_22.oldInputValue!=undefined){
box.val(_22.oldInputValue);
_22.oldInputValue=undefined;
}
var tb=box.parent();
if(_26){
tb.removeClass("textbox-invalid");
}else{
tb.addClass("textbox-invalid");
}
_22.onValidate.call(_21,_26);
}}));
};
function _27(_28){
var _29=$.data(_28,"textbox");
var _2a=_29.options;
var tb=_29.textbox;
var _2b=tb.find(".textbox-text");
_2b.attr("placeholder",_2a.prompt);
_2b.unbind(".textbox");
$(_29.label).unbind(".textbox");
if(!_2a.disabled&&!_2a.readonly){
if(_29.label){
$(_29.label).bind("click.textbox",function(e){
if(!_2a.hasFocusMe){
_2b.focus();
$(_28).textbox("setSelectionRange",{start:0,end:_2b.val().length});
}
});
}
_2b.bind("blur.textbox",function(e){
if(!tb.hasClass("textbox-focused")){
return;
}
_2a.value=$(this).val();
if(_2a.value==""){
$(this).val(_2a.prompt).addClass("textbox-prompt");
}else{
$(this).removeClass("textbox-prompt");
}
tb.removeClass("textbox-focused");
}).bind("focus.textbox",function(e){
_2a.hasFocusMe=true;
if(tb.hasClass("textbox-focused")){
return;
}
if($(this).val()!=_2a.value){
$(this).val(_2a.value);
}
$(this).removeClass("textbox-prompt");
tb.addClass("textbox-focused");
});
for(var _2c in _2a.inputEvents){
_2b.bind(_2c+".textbox",{target:_28},_2a.inputEvents[_2c]);
}
}
var _2d=tb.find(".textbox-addon");
_2d.unbind().bind("click",{target:_28},function(e){
var _2e=$(e.target).closest("a.textbox-icon:not(.textbox-icon-disabled)");
if(_2e.length){
var _2f=parseInt(_2e.attr("icon-index"));
var _30=_2a.icons[_2f];
if(_30&&_30.handler){
_30.handler.call(_2e[0],e);
}
_2a.onClickIcon.call(_28,_2f);
}
});
_2d.find(".textbox-icon").each(function(_31){
var _32=_2a.icons[_31];
var _33=$(this);
if(!_32||_32.disabled||_2a.disabled||_2a.readonly){
_33.addClass("textbox-icon-disabled");
}else{
_33.removeClass("textbox-icon-disabled");
}
});
var btn=tb.find(".textbox-button");
btn.linkbutton((_2a.disabled||_2a.readonly)?"disable":"enable");
tb.unbind(".textbox").bind("_resize.textbox",function(e,_34){
if($(this).hasClass("easyui-fluid")||_34){
_11(_28);
}
return false;
});
};
function _d(_35,_36){
var _37=$.data(_35,"textbox");
var _38=_37.options;
var tb=_37.textbox;
var _39=tb.find(".textbox-text");
var ss=$(_35).add(tb.find(".textbox-value"));
_38.disabled=_36;
if(_38.disabled){
_39.blur();
_39.validatebox("disable");
tb.addClass("textbox-disabled");
ss.attr("disabled","disabled");
$(_37.label).addClass("textbox-label-disabled");
}else{
_39.validatebox("enable");
tb.removeClass("textbox-disabled");
ss.removeAttr("disabled");
$(_37.label).removeClass("textbox-label-disabled");
}
};
function _e(_3a,_3b){
var _3c=$.data(_3a,"textbox");
var _3d=_3c.options;
var tb=_3c.textbox;
var _3e=tb.find(".textbox-text");
_3d.readonly=_3b==undefined?true:_3b;
if(_3d.readonly){
_3e.triggerHandler("blur.textbox");
}
_3e.validatebox("readonly",_3d.readonly);
tb.removeClass("textbox-readonly").addClass(_3d.readonly?"textbox-readonly":"");
};
$.fn.textbox=function(_3f,_40){
if(typeof _3f=="string"){
var _41=$.fn.textbox.methods[_3f];
if(_41){
return _41(this,_40);
}else{
return this.each(function(){
var _42=$(this).textbox("textbox");
_42.validatebox(_3f,_40);
});
}
}
_3f=_3f||{};
return this.each(function(){
var _43=$.data(this,"textbox");
if(_43){
$.extend(_43.options,_3f);
if(_3f.value!=undefined){
_43.options.originalValue=_3f.value;
}
}else{
_43=$.data(this,"textbox",{options:$.extend({},$.fn.textbox.defaults,$.fn.textbox.parseOptions(this),_3f),textbox:_2(this)});
_43.options.originalValue=_43.options.value;
}
_6(this);
_27(this);
if(_43.options.doSize){
_11(this);
}
var _44=_43.options.value;
_43.options.value="";
$(this).textbox("initValue",_44);
});
};
$.fn.textbox.methods={options:function(jq){
return $.data(jq[0],"textbox").options;
},cloneFrom:function(jq,_45){
return jq.each(function(){
var t=$(this);
if(t.data("textbox")){
return;
}
if(!$(_45).data("textbox")){
$(_45).textbox();
}
var _46=$.extend(true,{},$(_45).textbox("options"));
var _47=t.attr("name")||"";
t.addClass("textbox-f").hide();
t.removeAttr("name").attr("textboxName",_47);
var _48=$(_45).next().clone().insertAfter(t);
var _49="_easyui_textbox_input"+(++_1);
_48.find(".textbox-value").attr("name",_47);
_48.find(".textbox-text").attr("id",_49);
var _4a=$($(_45).textbox("label")).clone();
if(_4a.length){
_4a.attr("for",_49);
if(_46.labelPosition=="after"){
_4a.insertAfter(t.next());
}else{
_4a.insertBefore(t);
}
}
$.data(this,"textbox",{options:_46,textbox:_48,label:(_4a.length?_4a:undefined)});
var _4b=$(_45).textbox("button");
if(_4b.length){
t.textbox("button").linkbutton($.extend(true,{},_4b.linkbutton("options")));
}
_27(this);
_c(this);
});
},textbox:function(jq){
return $.data(jq[0],"textbox").textbox.find(".textbox-text");
},button:function(jq){
return $.data(jq[0],"textbox").textbox.find(".textbox-button");
},label:function(jq){
return $.data(jq[0],"textbox").label;
},destroy:function(jq){
return jq.each(function(){
_f(this);
});
},resize:function(jq,_4c){
return jq.each(function(){
_11(this,_4c);
});
},disable:function(jq){
return jq.each(function(){
_d(this,true);
_27(this);
});
},enable:function(jq){
return jq.each(function(){
_d(this,false);
_27(this);
});
},readonly:function(jq,_4d){
return jq.each(function(){
_e(this,_4d);
_27(this);
});
},isValid:function(jq){
return jq.textbox("textbox").validatebox("isValid");
},clear:function(jq){
return jq.each(function(){
$(this).textbox("setValue","");
});
},setText:function(jq,_4e){
return jq.each(function(){
var _4f=$(this).textbox("options");
var _50=$(this).textbox("textbox");
_4e=_4e==undefined?"":String(_4e);
if($(this).textbox("getText")!=_4e){
_50.val(_4e);
}
_4f.value=_4e;
if(!_50.is(":focus")){
if(_4e){
_50.removeClass("textbox-prompt");
}else{
_50.val(_4f.prompt).addClass("textbox-prompt");
}
}
$(this).textbox("validate");
});
},initValue:function(jq,_51){
return jq.each(function(){
var _52=$.data(this,"textbox");
$(this).textbox("setText",_51);
_52.textbox.find(".textbox-value").val(_51);
$(this).val(_51);
});
},setValue:function(jq,_53){
return jq.each(function(){
var _54=$.data(this,"textbox").options;
var _55=$(this).textbox("getValue");
$(this).textbox("initValue",_53);
if(_55!=_53){
_54.onChange.call(this,_53,_55);
$(this).closest("form").trigger("_change",[this]);
}
});
},getText:function(jq){
var _56=jq.textbox("textbox");
if(_56.is(":focus")){
return _56.val();
}else{
return jq.textbox("options").value;
}
},getValue:function(jq){
return jq.data("textbox").textbox.find(".textbox-value").val();
},reset:function(jq){
return jq.each(function(){
var _57=$(this).textbox("options");
$(this).textbox("setValue",_57.originalValue);
});
},getIcon:function(jq,_58){
return jq.data("textbox").textbox.find(".textbox-icon:eq("+_58+")");
},getTipX:function(jq,_59){
var _5a=jq.data("textbox");
var _5b=_5a.options;
var tb=_5a.textbox;
var _5c=tb.find(".textbox-text");
var _59=_59||_5b.tipPosition;
var p1=tb.offset();
var p2=_5c.offset();
var w1=tb.outerWidth();
var w2=_5c.outerWidth();
if(_59=="right"){
return w1-w2-p2.left+p1.left;
}else{
if(_59=="left"){
return p1.left-p2.left;
}else{
return (w1-w2-p2.left+p1.left)/2-(p2.left-p1.left)/2;
}
}
},getTipY:function(jq,_5d){
var _5e=jq.data("textbox");
var _5f=_5e.options;
var tb=_5e.textbox;
var _60=tb.find(".textbox-text");
var _5d=_5d||_5f.tipPosition;
var p1=tb.offset();
var p2=_60.offset();
var h1=tb.outerHeight();
var h2=_60.outerHeight();
if(_5d=="left"||_5d=="right"){
return (h1-h2-p2.top+p1.top)/2-(p2.top-p1.top)/2;
}else{
if(_5d=="bottom"){
return (h1-h2-p2.top+p1.top);
}else{
return (p1.top-p2.top);
}
}
},getSelectionStart:function(jq){
return jq.textbox("getSelectionRange").start;
},getSelectionRange:function(jq){
var _61=jq.textbox("textbox")[0];
var _62=0;
var end=0;
if(typeof _61.selectionStart=="number"){
_62=_61.selectionStart;
end=_61.selectionEnd;
}else{
if(_61.createTextRange){
var s=document.selection.createRange();
var _63=_61.createTextRange();
_63.setEndPoint("EndToStart",s);
_62=_63.text.length;
end=_62+s.text.length;
}
}
return {start:_62,end:end};
},setSelectionRange:function(jq,_64){
return jq.each(function(){
var _65=$(this).textbox("textbox")[0];
var _66=_64.start;
var end=_64.end;
if(_65.setSelectionRange){
_65.setSelectionRange(_66,end);
}else{
if(_65.createTextRange){
var _67=_65.createTextRange();
_67.collapse();
_67.moveEnd("character",end);
_67.moveStart("character",_66);
_67.select();
}
}
});
}};
$.fn.textbox.parseOptions=function(_68){
var t=$(_68);
return $.extend({},$.fn.validatebox.parseOptions(_68),$.parser.parseOptions(_68,["prompt","iconCls","iconAlign","buttonText","buttonIcon","buttonAlign","label","labelPosition","labelAlign",{multiline:"boolean",iconWidth:"number",labelWidth:"number"}]),{value:(t.val()||undefined),type:(t.attr("type")?t.attr("type"):undefined)});
};
$.fn.textbox.defaults=$.extend({},$.fn.validatebox.defaults,{doSize:true,width:"auto",height:"auto",cls:null,prompt:"",value:"",type:"text",multiline:false,icons:[],iconCls:null,iconAlign:"right",iconWidth:18,buttonText:"",buttonIcon:null,buttonAlign:"right",label:null,labelWidth:"auto",labelPosition:"before",labelAlign:"left",inputEvents:{blur:function(e){
var t=$(e.data.target);
var _69=t.textbox("options");
if(t.textbox("getValue")!=_69.value){
t.textbox("setValue",_69.value);
}
},keydown:function(e){
if(e.keyCode==13){
var t=$(e.data.target);
t.textbox("setValue",t.textbox("getText"));
}
}},onChange:function(_6a,_6b){
},onResizing:function(_6c,_6d){
},onResize:function(_6e,_6f){
},onClickButton:function(){
},onClickIcon:function(_70){
}});
})(jQuery);

