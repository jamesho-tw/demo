package com.example.data.user.model.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "roles", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Role implements Serializable {

  /**
   * The serialVersionUID.
   */
  private static final long serialVersionUID = -8463119381628309910L;

  /**
   * The sequential unique ID.
   */
  private Long id;

  /**
   * The role name.
   */
  private String name;

  /**
   * The role memo.
   */
  private String memo;

  /**
   * The role status.
   */
  private int status;

  /**
   * Constructor.
   */
  public Role() {
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

  @Column(name = "name", unique = true, nullable = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Column(name = "memo")
  @Type(type = "text")
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  @Column(name = "status", nullable = false)
  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof User)) {
      return false;
    }

    Role other = (Role) obj;
    EqualsBuilder bulider = new EqualsBuilder();
    bulider.append(this.id, other.getId());
    bulider.append(this.name, other.getName());
    bulider.append(this.memo, other.getMemo());
    bulider.append(this.status, other.getStatus());
    return bulider.isEquals();
  }

  @Override
  public int hashCode() {
    // @formatter:off
    return new HashCodeBuilder()
        .append(id)
        .append(name)
        .append(memo)
        .append(status)
        .toHashCode();
    // @formatter:on
  }

  @Override
  public String toString() {
    // TODO: password protection
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE, true,
        Role.class);
  }

}
