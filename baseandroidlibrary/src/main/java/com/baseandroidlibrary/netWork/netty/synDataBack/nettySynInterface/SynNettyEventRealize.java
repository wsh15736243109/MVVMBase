package com.baseandroidlibrary.netWork.netty.synDataBack.nettySynInterface;

import android.util.Log;

import com.baseandroidlibrary.beanBase.BeanBase;
import com.baseandroidlibrary.eventBus.baseInterface.BaseReceiveEventBus;
import com.baseandroidlibrary.eventBus.eventReceive.EventSynServerBusPosting;
import com.baseandroidlibrary.netWork.netty.base.handler.inbound.AsyBaseChannelInBoundHandler;

/**
 * Created by zy on 2018/8/21.
 * NettySyn消息操作类,用于消息接收然后发送出去.
 */
public class SynNettyEventRealize implements BaseReceiveEventBus<BeanBase> {

    private AsyBaseChannelInBoundHandler synBaseChannelInBoundHandler;

    private EventSynServerBusPosting<BeanBase> eventSynServerBusPosting;

    public SynNettyEventRealize(AsyBaseChannelInBoundHandler synBaseChannelInBoundHandler) {
        eventSynServerBusPosting = new EventSynServerBusPosting(this);
        this.synBaseChannelInBoundHandler = synBaseChannelInBoundHandler;
    }

    public void setWriteMsg(String str) {
        eventSynServerBusPosting.setWriteMsg(str);
    }

    public void unregister() {
        eventSynServerBusPosting.unregister();
    }

    public void setClass(Class<?>... clazz) {
        eventSynServerBusPosting.setClass(clazz);
    }

    /**
     * 接收数据.
     *
     * @param o
     */
    @Override
    public void onReceiveEvent(BeanBase o) {
        Log.e("RoomHandler", "super onReceiveEvent" + o.toString());
        synBaseChannelInBoundHandler.handlerMessage(o);
    }

    /**
     * 接收粘性数据.
     *
     * @param o
     */
    @Override
    public void onReceiveStickyEvent(BeanBase o) {

    }
}
