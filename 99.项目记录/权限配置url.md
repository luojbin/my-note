# 权限配置

- 查看权限配置

  - 获取权限组列表  resource/getGroupList
  - **查看权限组包含权限(未完成)**  resource/getGroupResources
  - 根据区域获取用户列表(共用)  area/getUserGroups
  - 根据岗位获取用户列表(共用)  position/getUserGroups

- 编辑权限配置(依赖于 `权限分配` 权限)

  - 新增/重命名权限组  resource/saveGroup
  - 删除权限组  resource/removeGroup

  - **保存权限组包含权限(全量/未完成)**  resource/saveGroupResource

  - 新增权限组成员(增量)  resource/addGroupMembers
  - 删除权限组成员(增量)  resource/removeGroupMember

- **权限分配(未完成), **

  - 每个权限分配对应的url 都是以下三个
    - resource/saveGroupResource
    - resource/savePositionResource
    - resource/savePositionGroup

  - 客户管理权限		
  - 拜访记录权限
  - 注册审批权限
  - 系统用户管理权限
  - 权限管理权限

#### 岗位配置

- 查看岗位配置

  - 获取岗位列表  position/getList
  - 查询岗位包含权限组  position/getResourceGroup
  - 查询岗位包含的权限  position/getResourceList
  - 查询岗位包含的成员  position/getMembers
  - 根据区域获取用户列表(共用)  area/getUserGroups

- 编辑岗位配置

  - 新增/重命名岗位 position/save
  - 删除岗位 position/remove
  - **保存岗位包含的权限组(全量/未完成)**

  - **保存岗位包含的权限(全量/未完成)**

  - 新增岗位成员(增量)  position/addMember
  - 删除岗位成员(增量)  position/removeMember

#### 区域信息配置

- 查看区域配置

  - 获取区域列表  area/list
  - 获取未分配区域的省份(暂时不做)
  - 根据手机/姓名查询区总  area/areaLeader

- 编辑区域配置

  - 删除区域  area/remove
  - 重命名区域  area/remove
  - 保存区域的区总  area/addLeader
  - 删除区域的区总  area/removeLeader
  - 新增区域(暂时不做)
  - 区域移除省份(暂时不做)
  - 区域新增省份(暂时不做)
