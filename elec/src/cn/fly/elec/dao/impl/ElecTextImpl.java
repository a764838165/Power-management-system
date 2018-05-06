package cn.fly.elec.dao.impl;

import org.springframework.stereotype.Repository;

import cn.fly.elec.dao.ICommomDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.domain.ElecText;
@Repository(IElecTextDao.SERVICE_NAME)
public class ElecTextImpl extends CommomImpl<ElecText> implements IElecTextDao {

}
