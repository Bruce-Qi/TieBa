package cn.tf.dao;

import java.util.List;

import cn.tf.domain.Topic;

public interface TopicDao {
	
	//查询所有
	public List<Topic>  findAll();
	
	//添加主题
	public void save(Topic topic);
	
	//通过id查找
	public Topic findById(Integer id);
	
	

}
