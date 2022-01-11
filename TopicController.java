package com.example.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {
    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics")
    public List<Topic> alltopics(){
        return topicService.getAllTopicList();
    }

    @RequestMapping(value="/{id}")
    public Topic getTopic(@PathVariable("id") String id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method =RequestMethod.PUT,value="/topics")
    public String addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
        return "Added...";
    }

    @RequestMapping(method =RequestMethod.PUT,value="/topics/{id}")
    public String updateTopic(@RequestBody Topic topic,@PathVariable("id") String id){
        topicService.updateTopic(topic, id);
        return "Updated...";
    }

    @RequestMapping(method =RequestMethod.DELETE,value="/topics/{id}")
    public String deleteTopic(@PathVariable("id") String id){
        topicService.deleteTopic(id);
        return "Deleted...";
    }
}


