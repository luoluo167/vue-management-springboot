package ${package.Controller};

import com.alibaba.excel.EasyExcel;
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${package.Service}.${table.serviceImplName};

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * <p>${table.comment!} 前端控制器</p>
 *
 * @author ${author}
 * @since ${date}
 */
<#if restControllerStyle>
@RestController
<#else>
@Controller
</#if>
<#if kotlin>
class ${table.controllerName}<#if superControllerClass??> : ${superControllerClass}()</#if>
<#else>
<#if superControllerClass??>
public class ${table.controllerName} extends ${superControllerClass} {
<#else>
public class ${table.controllerName} {
</#if>

    @Autowired
    private ${entity}Service ${table.entityPath}Service;

    @RequestMapping("/${table.entityPath}/page")
    public IPage<${entity}> page(@RequestBody ${entity}Query query){
        return ${table.entityPath}Service.page(query);
    }

    @RequestMapping("/${table.entityPath}/list")
    public List<${entity}> list(@RequestBody ${entity}Query query){
        return ${table.entityPath}Service.list();
    }

    @RequestMapping("/${table.entityPath}/findById")
    public ResponseData findById(@RequestParam Integer id) {
        ${entity} ${table.entityPath} = ${table.entityPath}Service.getById(id);
        return ResponseData.success(${table.entityPath});
    }

    @RequestMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.save(${table.entityPath});
        return ResponseData.success(${table.entityPath});
    }

    @RequestMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath}) {
        ${table.entityPath}Service.updateById(${table.entityPath});
        return ResponseData.success(${table.entityPath});
    }

    @RequestMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id) {
        ${table.entityPath}Service.removeByIds(id);
        return ResponseData.success(id);
    }

    @ResponseBody
    @RequestMapping("/${table.entityPath}/export")
    public void export(${entity}Query query, HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("${table.comment!}.xlsx", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        EasyExcel.write(response.getOutputStream(), ${entity}.class).sheet("${table.comment!}").doWrite(list(query));
    }
}
</#if>
