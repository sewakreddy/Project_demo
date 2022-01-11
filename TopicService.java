package com.example.app.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topicList = new ArrayList<>(Arrays.asList(

            new Topic("spring mvc", "Spring mvc tool", "Spring mvc Description"),
            new Topic("spring", "Spring FrameWork", "Spring Description"),
            new Topic("java", "Java FrameWork", "Java Description")

    ));

    public List<Topic> getAllTopicList() {
        return topicList;
    }

    public Topic getTopic(String id){
        return topicList.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        topicList.add(topic);
    }

    public void updateTopic(Topic topic,String id){
        int count=0;
        for (Topic topic1:topicList)
        {
            if(topic1.getId().equals(id))
            {
                topicList.set(count,topic1);
            }
            count++;
        }

    }

    public void deleteTopic(String id){
        topicList.removeIf(topic -> topic.getId().equals(id));
    }
}
