package NellDora.jpa_and_security.security.dto;

public class AuthDTO {

    private String memberId;
    private String MemberNum;
    private String urlNum;
    private String url;

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberNum() {
        return MemberNum;
    }

    public void setMemberNum(String memberNum) {
        MemberNum = memberNum;
    }

    public String getUrlNum() {
        return urlNum;
    }

    public void setUrlNum(String urlNum) {
        this.urlNum = urlNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
