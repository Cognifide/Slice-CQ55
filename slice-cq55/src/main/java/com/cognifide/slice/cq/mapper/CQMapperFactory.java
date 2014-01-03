package com.cognifide.slice.cq.mapper;

/*
 * #%L
 * Slice - CQ Add-on
 * $Id:$
 * $HeadURL:$
 * %%
 * Copyright (C) 2012 Cognifide Limited
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
import com.cognifide.slice.cq.mapper.processor.ImageFieldProcessor;
import com.cognifide.slice.mapper.MapperBuilder;
import com.cognifide.slice.mapper.api.Mapper;
import com.cognifide.slice.mapper.api.MapperFactory;
import com.cognifide.slice.mapper.api.processor.FieldPostProcessor;
import com.cognifide.slice.mapper.api.processor.FieldProcessor;
import com.google.inject.Inject;

public class CQMapperFactory implements MapperFactory {

	private final MapperBuilder mapperBuilder;

	@Inject
	public CQMapperFactory(final MapperBuilder mapperBuilder) {
		this.mapperBuilder = mapperBuilder;
	}

	@Override
	public Mapper getMapper() {
		return mapperBuilder.addDefaultSlingProcessors().addFieldProcessor(new ImageFieldProcessor()).build();
	}

	@Override
	public void registerFieldProcessor(FieldProcessor fieldProcessor, Mapper mapper) {
		mapper.registerFieldProcessor(fieldProcessor);
	}

	@Override
	public void unregisterFieldProcessor(FieldProcessor fieldProcessor, Mapper mapper) {
		mapper.unregisterFieldProcessor(fieldProcessor);
	}

	@Override
	public void registerFieldPostProcessor(FieldPostProcessor fieldPostProcessor, Mapper mapper) {
		mapper.registerFieldPostProcessor(fieldPostProcessor);
	}

	@Override
	public void unregisterFieldPostProcessor(FieldPostProcessor fieldPostProcessor, Mapper mapper) {
		mapper.unregisterFieldPostProcessor(fieldPostProcessor);
	}

}
