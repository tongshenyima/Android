package com.example.day0611;

import java.util.List;

public class Word {
    /**
     * reason : success
     * result : {"bushou":"人","head":"人","pinyin":"rén shān rén hǎi","chengyujs":" 人群如山似海。形容人聚集得非常多。","from_":" 明·施耐庵《水浒全传》第五十一回：\u201c每日有那一般打散，或是戏舞，或是吹弹，或是歌唱，赚得那人山人海价看。\u201d","example":" 节日的公园～，热闹极了。","yufa":" 联合式；作谓语、补语、定语、宾语；用于公共场所","ciyujs":"[huge crowds of people] 形容汇聚的人极多","yinzhengjs":"形容人聚集得极多。《水浒传》第五一回：\u201c每日有那一般打散，或有戏舞，或有吹弹，或有歌唱，赚得那人山人海价看。\u201d《醒世恒言·杜子春三入长安》：\u201c到得城南，只见人山人海，填街塞巷。\u201d 瞿秋白 《赤都心史》二：\u201c远远的就看见人山人海，各种旗帜招飐着。\u201d","tongyi":["川流不息","人头攒动"],"fanyi":["荒无人烟","人迹罕至"]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * bushou : 人
         * head : 人
         * pinyin : rén shān rén hǎi
         * chengyujs :  人群如山似海。形容人聚集得非常多。
         * from_ :  明·施耐庵《水浒全传》第五十一回：“每日有那一般打散，或是戏舞，或是吹弹，或是歌唱，赚得那人山人海价看。”
         * example :  节日的公园～，热闹极了。
         * yufa :  联合式；作谓语、补语、定语、宾语；用于公共场所
         * ciyujs : [huge crowds of people] 形容汇聚的人极多
         * yinzhengjs : 形容人聚集得极多。《水浒传》第五一回：“每日有那一般打散，或有戏舞，或有吹弹，或有歌唱，赚得那人山人海价看。”《醒世恒言·杜子春三入长安》：“到得城南，只见人山人海，填街塞巷。” 瞿秋白 《赤都心史》二：“远远的就看见人山人海，各种旗帜招飐着。”
         * tongyi : ["川流不息","人头攒动"]
         * fanyi : ["荒无人烟","人迹罕至"]
         */

        private String bushou;
        private String head;
        private String pinyin;
        private String chengyujs;
        private String from_;
        private String example;
        private String yufa;
        private String ciyujs;
        private String yinzhengjs;
        private List<String> tongyi;
        private List<String> fanyi;

        public String getBushou() {
            return bushou;
        }

        public void setBushou(String bushou) {
            this.bushou = bushou;
        }

        public String getHead() {
            return head;
        }

        public void setHead(String head) {
            this.head = head;
        }

        public String getPinyin() {
            return pinyin;
        }

        public void setPinyin(String pinyin) {
            this.pinyin = pinyin;
        }

        public String getChengyujs() {
            return chengyujs;
        }

        public void setChengyujs(String chengyujs) {
            this.chengyujs = chengyujs;
        }

        public String getFrom_() {
            return from_;
        }

        public void setFrom_(String from_) {
            this.from_ = from_;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getYufa() {
            return yufa;
        }

        public void setYufa(String yufa) {
            this.yufa = yufa;
        }

        public String getCiyujs() {
            return ciyujs;
        }

        public void setCiyujs(String ciyujs) {
            this.ciyujs = ciyujs;
        }

        public String getYinzhengjs() {
            return yinzhengjs;
        }

        public void setYinzhengjs(String yinzhengjs) {
            this.yinzhengjs = yinzhengjs;
        }

        public List<String> getTongyi() {
            return tongyi;
        }

        public void setTongyi(List<String> tongyi) {
            this.tongyi = tongyi;
        }

        public List<String> getFanyi() {
            return fanyi;
        }

        public void setFanyi(List<String> fanyi) {
            this.fanyi = fanyi;
        }
    }
}
