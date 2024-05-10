package kg.mega.atmtest.controlles;

import kg.mega.atmtest.models.dto.AccountPinDto;
import kg.mega.atmtest.models.dto.BalanceAndStatusDto;
import kg.mega.atmtest.services.PinService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/with")
public class PinController {

    private final PinService pinService;

    public PinController(PinService pinService) {
        this.pinService = pinService;
    }

    @PutMapping("/check")
    public BalanceAndStatusDto checkPin(@RequestBody AccountPinDto accountPinDto){
        return pinService.checkPin(accountPinDto);
    }

}
