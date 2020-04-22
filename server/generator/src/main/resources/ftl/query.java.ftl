package ${cfg.basePackage}.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel("${table.comment!}查询条件")
public class ${entity}Query extends PageQuery {

    <#list table.fields as field>
    @ApiModelProperty(value = "${field.comment}", notes = "${field.comment}")
    private String ${field.propertyName};
    </#list>
}
