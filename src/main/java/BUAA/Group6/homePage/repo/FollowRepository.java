package BUAA.Group6.homePage.repo;

import BUAA.Group6.homePage.model.Follow;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FollowRepository extends MongoRepository<Follow, String> {
    List<Follow> getFollowsByFanId(String fanId);
    List<Follow> getFollowsByFollowedId(String followedId);
    Follow getFollowByFanIdAndAndFollowedId(String fanId, String followedId);
}

