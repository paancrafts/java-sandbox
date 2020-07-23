package com.hellokoding.account.repository;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.hellokoding.account.model.Qualification;  
  
public class QualificationDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Qualification p){  
    String sql="insert into qualification(employeeId,name,level) values('"+p.getEmployeeId()+"','"+p.getQualification()+"','"+p.getLevel()+"')";  
    return template.update(sql);  
}  
public int update(Qualification p){  
    String sql="update qualification set name='"+p.getQualification()+"', employeeId="+p.getEmployeeId()+",level='"+p.getLevel()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(long id){  
    String sql="delete from qualification where id="+id+"";  
    return template.update(sql);  
}  
public Qualification getQualificationById(long id){  
    String sql="select * from qualification where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Qualification>(Qualification.class));  
}  
public List<Qualification> getQualifications(){  
    return template.query("select * from qualification",new RowMapper<Qualification>(){  
        public Qualification mapRow(ResultSet rs, int row) throws SQLException {  
            Qualification e=new Qualification();  
            e.setId(rs.getInt(1));  
            e.setEmployeeId(rs.getInt(2));  
            e.setQualification(rs.getString(3));  
            e.setLevel(rs.getInt(4));  
            return e;  
        }  
    });  
}
//public List<Qualification> getEmpQualifications(long id){  
//    return template.query("SELECT q.* FROM employee AS e JOIN qualification AS q ON e.id=q.employeeId WHERE e.id=" + id,new RowMapper<Qualification>(){  
//        public Qualification mapRow(ResultSet rs, int row) throws SQLException {  
//            Qualification e=new Qualification();  
//            e.setId(rs.getInt(1));  
//            e.setEmployeeId(rs.getLong(2));  
//            e.setQualification(rs.getString(3));  
//            e.setLevel(rs.getInt(4));  
//            return e;  
//        }  
//    });  
//}
}  