package edu.lys.dao;

import java.util.List;

import edu.lys.entity.Composition;
import edu.lys.entity.Marque;
import edu.lys.entity.Types;

public interface ITypes {

	//查找所有类型
	public List<Types> searchAllTypes();
	
	//根据类型id查找型号
	public List<Marque> searchMarqueByTypesId(int typesId);
	
	//根据型号id查找成分
	public List<Composition> searchCompositionByMarqueId(int marqueId);
}
