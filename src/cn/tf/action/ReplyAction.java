package cn.tf.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.tf.domain.Reply;
import cn.tf.domain.Topic;
import cn.tf.service.BusinessService;
import cn.tf.service.impl.BusinessServiceImpl;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReplyAction   extends ActionSupport implements ModelDriven<Reply>{
	
	private Reply  reply=new Reply();
	private Topic topic=new Topic();
	private BusinessService businessService = new BusinessServiceImpl();
	
	
	@Override
	public Reply getModel() {
		
		return reply;
	}
	
	
	//添加
	public String add(){
		//自动生成的数据
		reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
		// 1.2 创建时间
		reply.setCreateDate(new Date());
		
		//操作
		businessService.addReply(reply);
		

		return "add";
	}
	


}
