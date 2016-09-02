package cn.tf.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.tf.domain.Topic;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TopicAction   extends ActionSupport implements ModelDriven<Topic>{
	private Topic topic=new Topic();
	private BusinessService  businessService=new BusinessServiceImpl();
	
	
	@Override
	public Topic getModel() {
		
		return topic;
	}
	
	//查询
	public String findAll(){
		//查询所有，存放值栈中
		List<Topic> findAllTopic = businessService.findAllTopic();
		
		ActionContext.getContext().getValueStack().set("findAllTopic",findAllTopic);
		return "findAll";
	}
	
	
	//添加
	public String add(){
		//自动生成的数据
		topic.setCreateDate(new Date());
		topic.setReplayTime(topic.getCreateDate());
		topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		
		businessService.addTopic(topic);
		
		return "add";
	}
	
	//通过id查询
	public String findById(){
		Topic ftopic=businessService.findTopicById(topic.getId());
		
		//放到content中
		ActionContext.getContext().put("ftopic", ftopic);
		
	
		return "findById";
	}
	
	

}
