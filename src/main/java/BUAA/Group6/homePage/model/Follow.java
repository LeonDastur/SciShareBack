package BUAA.Group6.homePage.model;


import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @leonDastur
 * follow 关系，主键为mongodb中的_id
 */

@Document(collection = "follow")
public class Follow {
    String fanId;
    String followedId;

    public String getFanId() {
        return fanId;
    }

    public void setFanId(String fanId) {
        this.fanId = fanId;
    }

    public String getFollowedId() {
        return followedId;
    }

    public void setFollowedId(String followedId) {
        this.followedId = followedId;
    }
}
