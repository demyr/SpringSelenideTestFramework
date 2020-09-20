package com.pojos.user;

import com.pojos.common.AuditDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data(staticConstructor = "of")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class UserGetDTO extends AuditDTO {
    UserData data;
    UserAd ad;
}
