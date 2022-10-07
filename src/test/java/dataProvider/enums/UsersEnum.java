package dataProvider.enums;

import models.UserApp;

public enum UsersEnum {
    VALID_USER {
        public UserApp getUser() {
            return UserApp.builder()
                    .username("94365907093")
                    .password("panvel")
                    .build();
        }
    },
    INVALID_USER {
        public UserApp getUser() {
            return UserApp.builder()
                    .username("943659070934454545")
                    .password("panvel")
                    .build();
        }
    },
    VALID_USER_WITH_WRONG_PASSWORD {
        public UserApp getUser() {
            return UserApp.builder()
                    .username("94365907093")
                    .password("sjiajsiaisjaijs")
                    .build();
        }
    };

    public abstract UserApp getUser();
}
