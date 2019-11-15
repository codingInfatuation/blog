package per.czt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import per.czt.mapper.LabelMapper;
import per.czt.service.LabelService;
@Service
public class LabelServiceImpl implements LabelService {

	@Autowired
	private LabelMapper labelMapper;
}
