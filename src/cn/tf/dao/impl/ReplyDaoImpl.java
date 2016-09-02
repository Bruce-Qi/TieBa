package cn.tf.dao.impl;

import cn.tf.dao.ReplyDao;
import cn.tf.domain.Reply;
import cn.tf.utils.H3Utils;

public class ReplyDaoImpl  implements ReplyDao {

	@Override
	public void save(Reply reply) {
		H3Utils.getCurrentSession().save(reply);
	}

}
