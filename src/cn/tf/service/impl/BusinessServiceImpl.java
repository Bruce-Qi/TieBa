package cn.tf.service.impl;

import java.util.List;

import cn.tf.dao.ReplyDao;
import cn.tf.dao.TopicDao;
import cn.tf.dao.impl.ReplyDaoImpl;
import cn.tf.dao.impl.TopicDaoImpl;
import cn.tf.domain.Reply;
import cn.tf.domain.Topic;
import cn.tf.service.BusinessService;

public class BusinessServiceImpl implements BusinessService{

	private TopicDao topicDao=new TopicDaoImpl();
	private ReplyDao  replyDao=new ReplyDaoImpl();
	
	@Override
	public List<Topic> findAllTopic() {
		return topicDao.findAll();
	}

	@Override
	public void addTopic(Topic topic) {
		topicDao.save(topic);
		
	}

	@Override
	public Topic findTopicById(Integer id) {
		return topicDao.findById(id);
	}

	@Override
	public void addReply(Reply reply) {
		replyDao.save(reply);
		
	}


}
