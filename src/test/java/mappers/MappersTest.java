package mappers;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MappersTest {

    @Test
    void fromEntity() {
        Mappers<User, UserDTO> mappers = new Mappers<>();
        User user = new User(1L, 2, "name", new Date(), 2, 29, BigDecimal.valueOf(3999));
        UserDTO userDTO = mappers.fromEntity(user, UserDTO.class);
        assertNotNull(userDTO);
        assertEquals(userDTO.getAge(), user.getAge());
        assertEquals(userDTO.getNumber(), user.getNumber());
        assertEquals(userDTO.getAmout(), user.getAmout());
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getDate(), user.getDate());
        assertEquals(userDTO.getSpeed(), user.getSpeed());
        assertEquals(userDTO.getName(), user.getName());
    }

    @Test
    void fromDTO() {
        Mappers<User, UserDTO> mappers = new Mappers<>();
        UserDTO userDTO = new UserDTO(1L, 2, "name", new Date(), 2, 29, BigDecimal.valueOf(3999));
        User user = mappers.fromDTO(userDTO, User.class);
        assertNotNull(userDTO);
        assertEquals(userDTO.getAge(), user.getAge());
        assertEquals(userDTO.getNumber(), user.getNumber());
        assertEquals(userDTO.getAmout(), user.getAmout());
        assertEquals(userDTO.getId(), user.getId());
        assertEquals(userDTO.getDate(), user.getDate());
        assertEquals(userDTO.getSpeed(), user.getSpeed());
        assertEquals(userDTO.getName(), user.getName());
    }
}

class User{
    private Long id;
    private int number;
    private String name;
    private Date date;
    private float speed;
    private Integer age;
    private BigDecimal amout;

    public User(Long id, int number, String name, Date date, float speed, Integer age, BigDecimal amout) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.date = date;
        this.speed = speed;
        this.age = age;
        this.amout = amout;
    }

    public User() {
        super();
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public float getSpeed() {
        return speed;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getAmout() {
        return amout;
    }

}

class UserDTO{
    private Long id;
    private int number;
    private String name;
    private Date date;
    private float speed;
    private Integer age;
    private BigDecimal amout;

    public UserDTO(Long id, int number, String name, Date date, float speed, Integer age, BigDecimal amout) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.date = date;
        this.speed = speed;
        this.age = age;
        this.amout = amout;
    }

    public UserDTO() {
        super();
    }

    public Long getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public float getSpeed() {
        return speed;
    }

    public Integer getAge() {
        return age;
    }

    public BigDecimal getAmout() {
        return amout;
    }
}