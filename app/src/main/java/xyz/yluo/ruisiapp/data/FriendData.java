package xyz.yluo.ruisiapp.data;

/**
 * Created by free2 on 16-4-12.
 * 好友列表data
 */
public class FriendData {

    private String userName;
    private String imgUrl;
    private String info;
    private String uid;

    public FriendData(String userName, String imgUrl, String info, String uid) {
        this.userName = userName;
        this.imgUrl = imgUrl;
        this.info = info;
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getInfo() {
        return info;
    }

    public String getUid() {
        return uid;
    }
}
