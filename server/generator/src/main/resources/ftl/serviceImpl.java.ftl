package ${package.ServiceImpl};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import ${superServiceImplClassPackage};
import ${package.Entity}.${entity};
import ${package.Mapper}.${table.mapperName};
import ${cfg.basePackage}.query.${entity}Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>${table.comment!} 服务实现类</p>
 *
 * @author ${author}
 * @since ${date}
 */
@Service
<#if kotlin>
open class ${table.serviceImplName} : ${superServiceImplClass}<${table.mapperName}, ${entity}>(), ${table.serviceName} {

<#else>
@Transactional
public class ${table.serviceImplName} extends ${superServiceImplClass}<${table.mapperName}, ${entity}> {

    public IPage<${entity}> page(${entity}Query query) {
        QueryWrapper<${entity}> wrapper = new QueryWrapper<>();
        <#list table.fields as field>
        <#if field.propertyType=='String'>
        if (StringUtils.isNotBlank(query.get${field.capitalName}())) {
            wrapper.like("${field.name}", query.get${field.capitalName}());
        }
        <#else>
        if (query.get${field.capitalName}() != null) {
            wrapper.eq("${field.name}", query.get${field.capitalName}());
        }
        </#if>
        </#list>
        return super.page(query, wrapper);
    }

    @Override
    public boolean updateById(${entity} ${table.entityPath}) {
        ${entity} db${entity} = getById(${table.entityPath}.get${entity}Id());
        <#list table.fields as field>
        <#if !field.keyFlag>
        db${entity}.set${field.capitalName}(${table.entityPath}.get${field.capitalName}());
        </#if>
        </#list>
        return super.updateById(${table.entityPath});
    }
</#if>
}

