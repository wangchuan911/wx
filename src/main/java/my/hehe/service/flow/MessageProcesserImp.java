package my.hehe.service.flow;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import my.hehe.entity.HtmlInfo;
import my.hehe.entity.message.MessageCreater;
import my.hehe.entity.message.from.ImageMessageFromWX;
import my.hehe.entity.message.from.LinkMessageFromWX;
import my.hehe.entity.message.from.LocationMessageFromWX;
import my.hehe.entity.message.from.ShortVideoMessageFromWX;
import my.hehe.entity.message.from.TextMessageFromWX;
import my.hehe.entity.message.from.VideoMessageFromWX;
import my.hehe.entity.message.from.VoiceMessageFromWX;
import my.hehe.entity.message.to.ArticleMessageToWX;
import my.hehe.entity.message.to.ImageMessageToWX;
import my.hehe.entity.message.to.MessageToWX;
import my.hehe.entity.message.to.TextMessageToWX;
import my.hehe.entity.message.to.VideoMessageToWX;
import my.hehe.entity.message.to.VoiceMessageToWX;
import my.hehe.util.TSTDTZApi;

@Component
public class MessageProcesserImp implements MessageProcesser {
	@Resource
	TSTDTZApi api;

	public MessageToWX textProcess(TextMessageFromWX msg) {
		// TODO Auto-generated method stub
		MessageToWX to=null;
		if (msg.getContent().trim().equals("南宁")) {
			to=new ArticleMessageToWX(msg);
			List<HtmlInfo> infos=api.TD(msg.getContent().trim(), 1, 0);
			for (HtmlInfo htmlInfo : infos) {
				((ArticleMessageToWX)to).setArticleInfo(htmlInfo.getCreateDate(), htmlInfo.getInfo(), "", htmlInfo.getHref());
			}
			
		} else {
			to = new TextMessageToWX(msg);
			((TextMessageToWX )to).setContent("you say:" + msg.getContent());
		}
		return to;
	}

	public MessageToWX imageProcess(ImageMessageFromWX msg) {
		ImageMessageToWX to = new ImageMessageToWX(msg);
		to.setMediaId(msg.getMediaId());
		return to;
	}

	public MessageToWX linkProcess(LinkMessageFromWX msg) {
		ArticleMessageToWX to=new ArticleMessageToWX(msg);
		to.setArticleInfo(msg.getTitle(), msg.getDescription(), "", msg.getUrl());
		return to;
	}

	public MessageToWX locationProcess(LocationMessageFromWX msg) {
		// TODO Auto-generated method stub
		TextMessageToWX to = new TextMessageToWX(msg);
		to.setContent(msg.getLocation_X()+":"+msg.getLocation_Y());
		return to;
	}

	public MessageToWX shortVideoProcess(ShortVideoMessageFromWX msg) {
		// TODO Auto-generated method stub
		return null;
	}

	public MessageToWX videoProcess(VideoMessageFromWX msg) {
		VideoMessageToWX to = new VideoMessageToWX(msg);
		to.setVideoInfo(msg.getMsgId(), "AA", "SS");
		System.out.println(to.toString());

		return to;
	}

	public MessageToWX voiceProcess(VoiceMessageFromWX msg) {
		VoiceMessageToWX to = new VoiceMessageToWX(msg);
		to.setMediaId(msg.getMediaId());
		return to;
	}

}
