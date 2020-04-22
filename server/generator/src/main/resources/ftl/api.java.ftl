package ${cfg.basePackage}.api;

import ${package.Entity}.${entity};
import ${cfg.basePackage}.query.${entity}Query;
import ${cfg.basePackage}.response.ResponseData;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>${table.comment!} 服务调用端</p>
 *
 * @author ${author}
 * @since ${date}
*/
@FeignClient("artwork-${cfg.module}-producer")
public interface ${entity}Api {

    @RequestMapping("/${table.entityPath}/page")
    public Page<${entity}> page(@RequestBody ${entity}Query query);

    @RequestMapping("/${table.entityPath}/list")
    public List<${entity}> list();

    @RequestMapping("/${table.entityPath}/findById")
    public ResponseData findById(@RequestParam Integer id);

    @RequestMapping("/${table.entityPath}/save")
    public ResponseData save(@RequestBody ${entity} ${table.entityPath});

    @RequestMapping("/${table.entityPath}/update")
    public ResponseData update(@RequestBody ${entity} ${table.entityPath});

    @RequestMapping("/${table.entityPath}/delete")
    public ResponseData delete(@RequestParam List<Integer> id);

    @RequestMapping(value = "/${table.entityPath}/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    ResponseEntity<byte[]> export(@RequestParam Integer id);
}
