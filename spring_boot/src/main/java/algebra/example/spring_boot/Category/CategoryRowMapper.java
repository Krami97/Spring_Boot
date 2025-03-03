package algebra.example.spring_boot.Category;

import algebra.example.spring_boot.Article.Article;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRowMapper implements RowMapper<Category>{

        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Integer id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");

            return new Category(id,name,description);
        }

}
