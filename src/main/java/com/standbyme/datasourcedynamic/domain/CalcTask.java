package com.standbyme.datasourcedynamic.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Demo class
 *
 * @author Holger
 * @date 2017/4/9
 */
public class CalcTask {
    private Long id;

    private String taskname;

    private Long siteid;

    private Long mpointid;

    private Date startdt;

    private Date enddt;
    
    private String cycleStart;

    public String getCycleStart() {
		return cycleStart;
	}

	public void setCycleStart(String cycleStart) {
		this.cycleStart = cycleStart;
	}

	private Date start;

    private Date datadt;

    private Date finishdt;

    private CalcDate calcDate;

    private Long cycle;

    private Long code;

    private Long formulaid;

    private String status;

    private String excuteInfo;

    private String siteName;

    private String mpointName;

    private Date createTime;

    private Long createUserid;

    private Date updateTime;

    private Long updateUserid;

    private String remarks;

    private List<CalcTask> depend;

    private String expression;

    private long executeCount;

    private long executeSum;
    
    private String point;
    
    private String ftype;

    private Integer ShiftType;

    private Date cycleEnd;

    private Integer initialValue;

    public Integer getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Integer initialValue) {
        this.initialValue = initialValue;
    }

    public Date getCycleEnd() {
        return cycleEnd;
    }

    public void setCycleEnd(Date cycleEnd) {
        this.cycleEnd = cycleEnd;
    }

    public Integer getShiftType() {
        return ShiftType;
    }

    public void setShiftType(Integer shiftType) {
        ShiftType = shiftType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CalcTask calcTask = (CalcTask) o;

        if (!id.equals(calcTask.id)) {
            return false;
        }
        if (!mpointid.equals(calcTask.mpointid)) {
            return false;
        }
        if (!cycle.equals(calcTask.cycle)) {
            return false;
        }
        return formulaid.equals(calcTask.formulaid);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + mpointid.hashCode();
        result = 31 * result + cycle.hashCode();
        result = 31 * result + formulaid.hashCode();
        return result;
    }

    public boolean addDepend(CalcTask task) {
        if (depend == null) {
            depend = new ArrayList<CalcTask>();
        }
        if (depend.indexOf(task) == -1) {
            return depend.add(task);
        }
        return true;
    }

    public boolean addDepend(List<CalcTask> task) {
        if (task == null) {
            return false;
        }
        if (depend.indexOf(task) == -1) {
            return depend.addAll(task);
        }
        return true;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public long getExecuteCount() {
        return executeCount;
    }

    public void setExecuteCount(long executeCount) {
        this.executeCount = executeCount;
    }

    public long getExecuteSum() {
        return executeSum;
    }

    public void setExecuteSum(long executeSum) {
        this.executeSum = executeSum;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public CalcDate getCalcDate() {
        return calcDate;
    }

    public void setCalcDate(CalcDate calcDate) {
        this.calcDate = calcDate;
    }

    public Date getDatadt() {
        return datadt;
    }

    public void setDatadt(Date datadt) {
        this.datadt = datadt;
    }

    public Date getFinishdt() {
        return finishdt;
    }

    public void setFinishdt(Date finishdt) {
        this.finishdt = finishdt;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public List<CalcTask> getDepend() {
        return depend;
    }

    public void setDepend(List<CalcTask> depend) {
        this.depend = depend;
    }

    public String getMpointName() {
        return mpointName;
    }

    public void setMpointName(String mpointName) {
        this.mpointName = mpointName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public Long getSiteid() {
        return siteid;
    }

    public void setSiteid(Long siteid) {
        this.siteid = siteid;
    }

    public Long getMpointid() {
        return mpointid;
    }

    public void setMpointid(Long mpointid) {
        this.mpointid = mpointid;
    }

    public Date getStartdt() {
        return startdt;
    }

    public void setStartdt(Date startdt) {
        this.startdt = startdt;
    }

    public Date getEnddt() {
        return enddt;
    }

    public void setEnddt(Date enddt) {
        this.enddt = enddt;
    }

    public Long getCycle() {
        return cycle;
    }

    public void setCycle(Long cycle) {
        this.cycle = cycle;
    }

    public Long getFormulaid() {
        return formulaid;
    }

    public void setFormulaid(Long formulaid) {
        this.formulaid = formulaid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getExcuteInfo() {
        return excuteInfo;
    }

    public void setExcuteInfo(String excuteInfo) {
        this.excuteInfo = excuteInfo == null ? null : excuteInfo.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Long createUserid) {
        this.createUserid = createUserid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Long updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    @Override
    public String toString() {
        return "CalcTask{" +
                "id=" + id +
                ", taskname='" + taskname + '\'' +
                ", siteid=" + siteid +
                ", mpointid=" + mpointid +
                ", startdt=" + startdt +
                ", enddt=" + enddt +
                ", cycleStart='" + cycleStart + '\'' +
                ", start=" + start +
                ", datadt=" + datadt +
                ", finishdt=" + finishdt +
                ", calcDate=" + calcDate +
                ", cycle=" + cycle +
                ", code=" + code +
                ", formulaid=" + formulaid +
                ", status='" + status + '\'' +
                ", excuteInfo='" + excuteInfo + '\'' +
                ", siteName='" + siteName + '\'' +
                ", mpointName='" + mpointName + '\'' +
                ", createTime=" + createTime +
                ", createUserid=" + createUserid +
                ", updateTime=" + updateTime +
                ", updateUserid=" + updateUserid +
                ", remarks='" + remarks + '\'' +
                ", depend=" + depend +
                ", expression='" + expression + '\'' +
                ", executeCount=" + executeCount +
                ", executeSum=" + executeSum +
                ", point='" + point + '\'' +
                ", ftype='" + ftype + '\'' +
                ", ShiftType=" + ShiftType +
                '}';
    }
}
