package my.hehe.service.processer;

import my.hehe.entity.message.from.ImageMessageFromWX;
import my.hehe.entity.message.from.LinkMessageFromWX;
import my.hehe.entity.message.from.LocationMessageFromWX;
import my.hehe.entity.message.from.ShortVideoMessageFromWX;
import my.hehe.entity.message.from.TextMessageFromWX;
import my.hehe.entity.message.from.VideoMessageFromWX;
import my.hehe.entity.message.from.VoiceMessageFromWX;
import my.hehe.entity.message.to.ImageMessageToWX;
import my.hehe.entity.message.to.MessageToWX;
import my.hehe.entity.message.to.TextMessageToWX;

public interface MessageProcesser {
	public MessageToWX textProcess(TextMessageFromWX msg);

	public MessageToWX imageProcess(ImageMessageFromWX msg);

	public MessageToWX linkProcess(LinkMessageFromWX msg);

	public MessageToWX locationProcess(LocationMessageFromWX msg);

	public MessageToWX shortVideoProcess(ShortVideoMessageFromWX msg);

	public MessageToWX videoProcess(VideoMessageFromWX msg);

	public MessageToWX voiceProcess(VoiceMessageFromWX msg);
}