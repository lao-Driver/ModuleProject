package com.example.administrator.commonlibrary.bean;

import java.util.List;

public class MyBean {

    /**
     * success : true
     * errorCode : 0
     * message : 操作成功
     * result : [{"id":1,"indicatorName":"心率","indicatorUnit":"次/分钟","indicatorDirection":null,"goodRegionLow":60,"goodRegionUp":100,"indicatoreDesc":"60-100","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"XinLv"},{"id":2,"indicatorName":"血压_收缩压","indicatorUnit":"mmhg","indicatorDirection":null,"goodRegionLow":90,"goodRegionUp":140,"indicatoreDesc":"90<高压（收缩压）<140；","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"ShouSuoYa"},{"id":3,"indicatorName":"血压_舒张压","indicatorUnit":"mmhg","indicatorDirection":null,"goodRegionLow":60,"goodRegionUp":90,"indicatoreDesc":"60<低压（舒张压）<90","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"ShuZhangYa"},{"id":4,"indicatorName":"血氧","indicatorUnit":"%","indicatorDirection":null,"goodRegionLow":95,"goodRegionUp":98,"indicatoreDesc":"90左右","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"XueYang"},{"id":5,"indicatorName":"呼吸频率","indicatorUnit":"次","indicatorDirection":null,"goodRegionLow":67,"goodRegionUp":110,"indicatoreDesc":"儿童：胎儿（140-150)、初生婴儿(130-140)、1个月至1岁(110-130)、2岁(96-115)、3岁(86-105)、7岁-14岁(76-90)\n青老年：15-21岁(76-85)、21-60岁(70-75)、60岁以上(67-80)\nps：一般女性心跳速度比男性快，心跳速度会受呼吸速度影响，心跳速度会受体温影响，即每上升易度华氏便快10下（如下表）：\n98F     心跳60\n99F     心跳70\n100F   心跳80\n102F   心跳100\n104F   心跳120","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"HuXiPinLv"},{"id":6,"indicatorName":"肺活量","indicatorUnit":"毫升/ml","indicatorDirection":null,"goodRegionLow":2500,"goodRegionUp":5000,"indicatoreDesc":"成年男性：3500-4000、成年女性：2500-3500、经常参加体育运动的人：5000+\nps：肺活量随着年龄增长而减少","createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"FeiHuoLiang"},{"id":7,"indicatorName":"视力","indicatorUnit":null,"indicatorDirection":null,"goodRegionLow":null,"goodRegionUp":null,"indicatoreDesc":null,"createTime":1525768011000,"modifyTime":1525768011000,"status":1,"field":null,"descOverrideUp":null,"descUnderLower":null,"indicatorIdent":"ShiLi"}]
     */

    private boolean success;
    private String errorCode;
    private String message;
    private List<ResultBean> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 1
         * indicatorName : 心率
         * indicatorUnit : 次/分钟
         * indicatorDirection : null
         * goodRegionLow : 60
         * goodRegionUp : 100
         * indicatoreDesc : 60-100
         * createTime : 1525768011000
         * modifyTime : 1525768011000
         * status : 1
         * field : null
         * descOverrideUp : null
         * descUnderLower : null
         * indicatorIdent : XinLv
         */

        private int id;
        private String indicatorName;
        private String indicatorUnit;
        private Object indicatorDirection;
        private int goodRegionLow;
        private int goodRegionUp;
        private String indicatoreDesc;
        private long createTime;
        private long modifyTime;
        private int status;
        private Object field;
        private Object descOverrideUp;
        private Object descUnderLower;
        private String indicatorIdent;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIndicatorName() {
            return indicatorName;
        }

        public void setIndicatorName(String indicatorName) {
            this.indicatorName = indicatorName;
        }

        public String getIndicatorUnit() {
            return indicatorUnit;
        }

        public void setIndicatorUnit(String indicatorUnit) {
            this.indicatorUnit = indicatorUnit;
        }

        public Object getIndicatorDirection() {
            return indicatorDirection;
        }

        public void setIndicatorDirection(Object indicatorDirection) {
            this.indicatorDirection = indicatorDirection;
        }

        public int getGoodRegionLow() {
            return goodRegionLow;
        }

        public void setGoodRegionLow(int goodRegionLow) {
            this.goodRegionLow = goodRegionLow;
        }

        public int getGoodRegionUp() {
            return goodRegionUp;
        }

        public void setGoodRegionUp(int goodRegionUp) {
            this.goodRegionUp = goodRegionUp;
        }

        public String getIndicatoreDesc() {
            return indicatoreDesc;
        }

        public void setIndicatoreDesc(String indicatoreDesc) {
            this.indicatoreDesc = indicatoreDesc;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(long modifyTime) {
            this.modifyTime = modifyTime;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getField() {
            return field;
        }

        public void setField(Object field) {
            this.field = field;
        }

        public Object getDescOverrideUp() {
            return descOverrideUp;
        }

        public void setDescOverrideUp(Object descOverrideUp) {
            this.descOverrideUp = descOverrideUp;
        }

        public Object getDescUnderLower() {
            return descUnderLower;
        }

        public void setDescUnderLower(Object descUnderLower) {
            this.descUnderLower = descUnderLower;
        }

        public String getIndicatorIdent() {
            return indicatorIdent;
        }

        public void setIndicatorIdent(String indicatorIdent) {
            this.indicatorIdent = indicatorIdent;
        }
    }

    @Override
    public String toString() {
        return "MyBean{" +
                "success=" + success +
                ", errorCode='" + errorCode + '\'' +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }
}
