package com.hospital.open_api_document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.open_api_document.model.ApiCategory;
import com.hospital.open_api_document.model.ApiTopic;
import com.hospital.open_api_document.model.ApiType;
import com.hospital.open_api_document.repository.ApiCategoryRepository;
import com.hospital.open_api_document.repository.ApiTopicRepository;
import com.hospital.open_api_document.repository.ApiTypeRepository;
import com.hospital.open_api_document.types.ApiDoc;
import com.hospital.open_api_document.types.CategorySections;
import com.hospital.open_api_document.utils.StringHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// 数据库 API 文档信息数据提取服务
@Service
public class ApiDocumentService {
    @Autowired
    private ApiTopicRepository apiTopicRepository;

    @Autowired
    private ApiCategoryRepository apiCategoryRepository;

    @Autowired
    ApiTypeRepository apiTypeRepository;

    // 从数据库提取所有 API 文档的数据，包括他们的 API 种类和 API 话题信息， 不包括其属的 API 领域信息
    public Map<String, CategorySections> getAllSections() {
        List<ApiCategory> categoryList = apiCategoryRepository.findAll();
        List<ApiTopic> topicList = apiTopicRepository.findAll();
        Map<String, CategorySections> sections = new HashMap<>();
        for (ApiCategory category : categoryList)
            sections.put(category.getName(), new CategorySections(category.getNameCN()));
        for (ApiTopic topic : topicList) {
            ApiDoc temp = new ApiDoc(topic.getNameCn(), StringHelper.doNotShowEscapeDoubleQuote(topic.getContentMd()));
            sections.get(topic.getCategory().getName()).getTopics().put(topic.getName(), temp);
        }
        return sections;
    }

    // 根据 API 的领域 (e.g. 医院服务合作, 渠道合作) 进行相对应数据的查找
    public Map<String, CategorySections> getSectionsByType(String type) {
        // 从数据库中寻找领域， 返回相对应的 API 领域对象。不存方法直接返回 null 对象。
        Optional<ApiType> item = apiTypeRepository.findByName(type);
        ApiType apiType = item.isPresent() ? item.get() : null;
        if (apiType == null)
            return null;

        // 从数据库中寻找对应 API 领域的 API 种类， 加入要返回的参数中
        List<ApiCategory> categoryList = apiCategoryRepository.findByType(apiType);
        Map<String, CategorySections> sections = new HashMap<>();
        for (ApiCategory category : categoryList)
            sections.put(category.getName(), new CategorySections(category.getNameCN()));

        // 从数据库中提取所有 API 话题， 如果对应任何 API 种类， 加入要返回的参数当中
        List<ApiTopic> topicList = apiTopicRepository.findAll();
        for (ApiTopic topic : topicList) {
            if (!sections.containsKey(topic.getCategory().getName()))
                continue;
            ApiDoc temp = new ApiDoc(topic.getNameCn(), StringHelper.doNotShowEscapeDoubleQuote(topic.getContentMd()));
            sections.get(topic.getCategory().getName()).getTopics().put(topic.getName(), temp);
        }

        // 返回参数
        return sections;
    }
}
