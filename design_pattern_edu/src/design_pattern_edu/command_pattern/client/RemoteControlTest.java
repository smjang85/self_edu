package design_pattern_edu.command_pattern.client;

import design_pattern_edu.command_pattern.command.garage_door.GarageDoorUpCommand;
import design_pattern_edu.command_pattern.command.light.LightOnCommand;
import design_pattern_edu.command_pattern.invoker.SimpleRemoteControl;
import design_pattern_edu.command_pattern.receiver.GarageDoor;
import design_pattern_edu.command_pattern.receiver.Light;

/*
 * 6. 커맨드 패턴
 * 요구사항을 객체로 캡슐화할 수 있으며, 매개변수를 써서 여러 가지 다른 요구 사항을 집어넣을 수도 있습니다.
 * 또한 요청 내역을 쿠에 저장하거나 로그로 기록할 수 도 있으며, 작업취소 기능도 지원 가능합니다.
 * 
 * 클라이언트 -> 커맨드 -> 인보커 -> 커맨드 -> 리시버
 */
public class RemoteControlTest {
	public static void main(String[] args) {
		SimpleRemoteControl remote = new SimpleRemoteControl();
		Light light = new Light("");
		LightOnCommand lightOn = new LightOnCommand(light);
		GarageDoor garageDoor = new GarageDoor("");
		GarageDoorUpCommand garageDoorOpen = new GarageDoorUpCommand(garageDoor);
		
		remote.setCommand(lightOn);
		remote.buttonWasPressed();
		remote.setCommand(garageDoorOpen);
		remote.buttonWasPressed();
	}
}
