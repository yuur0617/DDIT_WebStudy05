package kr.or.ddit.qr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qrRead")
public class QrReadTest02 {

	@RequestMapping
	public String rqRead() {
		return "qr/qrRead";
	}
}
