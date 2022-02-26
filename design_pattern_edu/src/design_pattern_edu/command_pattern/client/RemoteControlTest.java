package design_pattern_edu.command_pattern.client;

import design_pattern_edu.command_pattern.command.garage_door.GarageDoorUpCommand;
import design_pattern_edu.command_pattern.command.light.LightOnCommand;
import design_pattern_edu.command_pattern.invoker.SimpleRemoteControl;
import design_pattern_edu.command_pattern.receiver.GarageDoor;
import design_pattern_edu.command_pattern.receiver.Light;

/*
 * 6. Ŀ�ǵ� ����
 * �䱸������ ��ü�� ĸ��ȭ�� �� ������, �Ű������� �Ἥ ���� ���� �ٸ� �䱸 ������ ������� ���� �ֽ��ϴ�.
 * ���� ��û ������ �� �����ϰų� �α׷� ����� �� �� ������, �۾���� ��ɵ� ���� �����մϴ�.
 * 
 * Ŭ���̾�Ʈ -> Ŀ�ǵ� -> �κ�Ŀ -> Ŀ�ǵ� -> ���ù�
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
