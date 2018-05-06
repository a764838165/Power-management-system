package cn.fly.elec.dao.impl;

import org.springframework.stereotype.Repository;

import cn.fly.elec.dao.ICommomDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.dao.IElecUserDao;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.domain.ElecUser;
@Repository(IElecUserDao.SERVICE_NAME)
public class ElecUserImpl extends CommomImpl<ElecUser> implements IElecUserDao {

}
