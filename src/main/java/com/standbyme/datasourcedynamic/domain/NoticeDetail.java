package com.standbyme.datasourcedynamic.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.io.Serializable;

/**
 * (TNoticeDetail)实体类
 *
 * @author makejava
 * @since 2021-03-17 14:49:07
 */
@Entity
@Table(name = "notice_detail")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class NoticeDetail implements Serializable {
    private static final long serialVersionUID = -57128624401691554L;
    /**
     * 消息公告ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 消息公告名称
     */
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    /**
     * 发布用户ID
     */
    @Column(name = "publish_user_id", nullable = true)
    private Long publishUserId;
    /**
     * 发布用户姓名
     */

    @Column(name = "publish_user_name", nullable = true)
    private String publishUserName;
    /**
     * 状态 1:未发布 2:未生效 3:已生效 4:已超时 5:已撤回
     */
    @NotNull
    @Column(name = "state", nullable = false)
    private Integer state;
    /**
     * 公告生效时间
     */
    @NotNull
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    /**
     * 公告结束时间(如果不填，认为永久有效)
     */
    @Column(name = "end_date", nullable = true)
    private Date endDate;
    /**
     * 正文
     */
    @NotNull
    @Column(name = "content", nullable = false)
    private String content;
    /**
     * 发布时间
     */
    @Column(name = "publish_date", nullable = true)
    private Date publishDate;
    /**
     * 正文格式化之后，去除标签，图片
     */
    @Column(name = "format_text", nullable = true)
    private String formatText;
    /**
     * 第一张图片地址
     */
    @Column(name = "first_picture", nullable = true)
    private String firstPicture;
    /**
     * 是否删除
     */
    @NotNull
    @Column(name = "delete_state", nullable = false)
    private Integer deleteState;

    @NotNull
    @Column(name = "create_user_id", nullable = false)
    private Long createUserId;

    @NotNull
    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_user_id", nullable = true)
    private Long updateUserId;

    @Column(name = "update_date", nullable = true)
    private Date updateDate;
    /**
     * 是否置顶
     */
    @NotNull
    @Column(name = "top_state", nullable = false)
    private Integer topState;
    /**
     * 租户ID
     */
    @NotNull
    @Column(name = "tenant_id", nullable = false)
    private Integer tenantId;
    /**
     * 组织IDs
     */
    @Column(name = "org_ids", nullable = true)
    private String orgIds;
    /**
     * 角色IDs
     */
    @Column(name = "role_ids", nullable = true)
    private String roleIds;
    /**
     * 用户IDs
     */
    @Column(name = "send_user_ids", nullable = true)
    private String sendUserIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(Long publishUserId) {
        this.publishUserId = publishUserId;
    }

    public String getPublishUserName() {
        return publishUserName;
    }

    public void setPublishUserName(String publishUserName) {
        this.publishUserName = publishUserName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getFormatText() {
        return formatText;
    }

    public void setFormatText(String formatText) {
        this.formatText = formatText;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public Integer getDeleteState() {
        return deleteState;
    }

    public void setDeleteState(Integer deleteState) {
        this.deleteState = deleteState;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getTopState() {
        return topState;
    }

    public void setTopState(Integer topState) {
        this.topState = topState;
    }

    public Integer getTenantId() {
        return tenantId;
    }

    public void setTenantId(Integer tenantId) {
        this.tenantId = tenantId;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getSendUserIds() {
        return sendUserIds;
    }

    public void setSendUserIds(String sendUserIds) {
        this.sendUserIds = sendUserIds;
    }

}
