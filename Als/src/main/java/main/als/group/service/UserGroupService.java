package main.als.group.service;

import main.als.group.dto.UserGroupResponseDto;
import main.als.group.entity.Group;
import main.als.user.dto.UserDto;
import main.als.user.entity.User;


import java.util.List;

public interface UserGroupService {
    public void joinUserGroup(Long groupId,String password,String username);
    public List<UserDto.UsernameDto> getUsersByGroupId(Long groupId);
}
