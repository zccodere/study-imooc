package com.imooc.chain;

/**
 * Created by cat on 2017-02-28.
 */
public abstract class Handler {

    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute(){
        handleProcess();
        if(sucessor != null){
            sucessor.execute();
        }
    }

    protected abstract void handleProcess();
}
