package com.zhhl.analysis.mvp.model;

public class LogReportData {

    private String cardNo;
    private String formatParam;
    private String logType;
    private String module;
    private String params;
    private String policeId;
    private String requestId;
    private String response;
    private String responseTime;
    private String sessionId;
    private String sn;
    private String sourceIp;
    private String sourcePort;

    public LogReportData() {
    }

    public String getCardNo() {

        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getFormatParam() {
        return formatParam;
    }

    public void setFormatParam(String formatParam) {
        this.formatParam = formatParam;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourcePort() {
        return sourcePort;
    }

    public void setSourcePort(String sourcePort) {
        this.sourcePort = sourcePort;
    }

    public String getTerminalIp() {
        return terminalIp;
    }

    public void setTerminalIp(String terminalIp) {
        this.terminalIp = terminalIp;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public LogReportData(String cardNo, String formatParam, String logType, String module, String params, String policeId, String requestId, String response, String responseTime, String sessionId, String sn, String sourceIp, String sourcePort, String terminalIp, String url) {

        this.cardNo = cardNo;
        this.formatParam = formatParam;
        this.logType = logType;
        this.module = module;
        this.params = params;
        this.policeId = policeId;
        this.requestId = requestId;
        this.response = response;
        this.responseTime = responseTime;
        this.sessionId = sessionId;
        this.sn = sn;
        this.sourceIp = sourceIp;
        this.sourcePort = sourcePort;
        this.terminalIp = terminalIp;
        this.url = url;
    }

    private String terminalIp;
    private String url;
}
