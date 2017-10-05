package com.example.data.user.model.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class User implements Serializable {

  /**
   * The serialVersionUID.
   */
  private static final long serialVersionUID = 6137876877215309729L;

  /**
   * The sequential unique ID.
   */
  private Long id;

  /**
   * The user account.
   */
  private String name;

  /**
   * The user password with hashed.
   */
  private String password;

  /**
   * The random string.
   */
  private String salt;

  /**
   * The created time.
   */
  private Date created;

  /**
   * The must change password flag.
   */
  private boolean mustChangePassword;

  /**
   * The user status.
   */
  private int status;

  /**
   * Constructor.
   */
  public User() {
  }

  /**
   * Calls the more complex constructor with <code>name</code> and <code>password</code> and
   * <code>salt</code> and <code>mustChangePassword</code>.
   *
   * @param name the user account
   * @param password the hashed password
   * @param salt the random string
   * @param mustChangePassword the must change password flag
   */
  public User(String name, String password, String salt, boolean mustChangePassword) {
    this(null, name, password, salt, new Date(), mustChangePassword, 1);
  }

  /**
   * Construct the <code>User</code> with the details.
   *
   * @param id the user ID
   * @param name the user account
   * @param password the hashed password
   * @param salt the random string
   * @param created the created time
   * @param mustChangePassword the must change password flag
   * @param status the user status
   */
  public User(Long id, String name, String password, String salt, Date created,
      boolean mustChangePassword, int status) {
    this.id = id;
    this.name = name;
    this.password = password;
    this.salt = salt;
    this.created = created;
    this.mustChangePassword = mustChangePassword;
    this.status = status;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Column(name = "name", unique = true, nullable = false, length = 32)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "secret", nullable = false, length = 128)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Column(name = "salt", length = 64)
  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_at", nullable = false, length = 19)
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Column(name = "must_change_secret", nullable = false)
  @Type(type = "org.hibernate.type.NumericBooleanType")
  public boolean isMustChangePassword() {
    return mustChangePassword;
  }

  public void setMustChangePassword(boolean mustChangePassword) {
    this.mustChangePassword = mustChangePassword;
  }

  @Column(name = "status", nullable = false)
  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

}
