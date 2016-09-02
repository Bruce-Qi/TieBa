package cn.tf.dao.impl;

import java.util.List;

import cn.tf.dao.TopicDao;
import cn.tf.domain.Topic;
import cn.tf.utils.H3Utils;

public class TopicDaoImpl implements TopicDao{

	@Override
	public List<Topic> findAll() {
		return H3Utils.getCurrentSession().createQuery("from Topic  order by replayTime desc").list();
	}

	@Override
	public void save(Topic topic) {
		H3Utils.getCurrentSession().save(topic);
	}

	@Override
	public Topic findById(Integer id) {
		return (Topic) H3Utils.getCurrentSession().get(Topic.class, id);
	}
	
	
	

}
