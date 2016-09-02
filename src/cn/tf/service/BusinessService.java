package cn.tf.service;

import java.util.List;

import cn.tf.domain.Reply;
import cn.tf.domain.Topic;

public interface BusinessService {
	
	//查询所有帖子
	public List<Topic> findAllTopic();
	//发布帖子
	public void addTopic(Topic topic);
	//通过id查找帖子
	public Topic findTopicById(Integer id);
	
	//添加回复
	public void addReply(Reply reply);
	

}
