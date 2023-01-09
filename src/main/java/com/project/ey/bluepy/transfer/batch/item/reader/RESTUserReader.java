package com.project.ey.bluepy.transfer.batch.item.reader;

import com.project.ey.bluepy.transfer.dtos.UserDTO;
import com.project.ey.bluepy.transfer.services.UserService;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RESTUserReader implements ItemReader<UserDTO> {

    @Autowired
    UserService userService;

    private int nextUserIndex;
    private List<UserDTO> userData;

    public RESTUserReader() {
        this.nextUserIndex = 0;
    }

    @Override
    public UserDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if(this.userData == null ){
            userData = userService.findAllUsersFromAPI();
        }

        UserDTO nextUser = null;

        if (nextUserIndex < userData.size()) {
            nextUser = userData.get(nextUserIndex);
            nextUserIndex++;
        }
        else {
            nextUserIndex = 0;
            userData = null;
        }

        return nextUser;
    }
}
