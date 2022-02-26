package design_pattern_edu.command_pattern.client;

import design_pattern_edu.command_pattern.command.Command;
import design_pattern_edu.command_pattern.command.MacroCommand;
import design_pattern_edu.command_pattern.command.ceiling.CeilingFanOffCommand;
import design_pattern_edu.command_pattern.command.ceiling.CeilingFanOnCommand;
import design_pattern_edu.command_pattern.command.garage_door.GarageDoorDownCommand;
import design_pattern_edu.command_pattern.command.garage_door.GarageDoorUpCommand;
import design_pattern_edu.command_pattern.command.light.LightOffCommand;
import design_pattern_edu.command_pattern.command.light.LightOnCommand;
import design_pattern_edu.command_pattern.command.stereo.StereoOffCommand;
import design_pattern_edu.command_pattern.command.stereo.StereoOnWithCDCommand;
import design_pattern_edu.command_pattern.invoker.RemoteControlWithUndo;
import design_pattern_edu.command_pattern.receiver.CeilingFan;
import design_pattern_edu.command_pattern.receiver.GarageDoor;
import design_pattern_edu.command_pattern.receiver.Light;
import design_pattern_edu.command_pattern.receiver.Stereo;
public class RemoteLoader {
	public static void main(String[] args) {
		//RemoteControl remoteControl = new RemoteControl();
		RemoteControlWithUndo remoteControl = new RemoteControlWithUndo();
		
		// 리시버 설정 ( 각 장치들을 설치합니다. 위치도 적절하게 설정
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor("");
		Stereo stereo = new Stereo("Living Room");
		
		// 커맨드 객체 설정
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		
		GarageDoorUpCommand garageDoorUp = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand gagareDoorDown = new GarageDoorDownCommand(garageDoor);
		
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		
		// 커맨드 로드
		remoteControl.setCommand(0,livingRoomLightOn, livingRoomLightOff);
		remoteControl.setCommand(1,kitchenLightOn, kitchenLightOff);
		remoteControl.setCommand(2,ceilingFanOn, ceilingFanOff);
		remoteControl.setCommand(3,stereoOnWithCD, stereoOff);
		
		System.out.println(remoteControl);
		
		// 각 슬롯 테스트
		// livingRoomLight 테스트
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		
		// kitchenLight 테스트
		remoteControl.onButtonWasPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.undoButtonWasPushed();
		
		// stereoOnWithCD 테스트
		remoteControl.onButtonWasPushed(3);
		remoteControl.offButtonWasPushed(3);
		remoteControl.undoButtonWasPushed();
		
		// ceilingFan 테스트
		remoteControl.onButtonWasPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.undoButtonWasPushed();
		
		
		System.out.println("### 메크로 커맨드 테스트 ###");
		Light light2 = new Light("Living Room");
		Stereo stereo2 = new Stereo("Living Room");
		
		LightOnCommand lightOn2 = new LightOnCommand(light2);
		LightOffCommand lightOff2 = new LightOffCommand(light2);
		
		StereoOnWithCDCommand stereoOnWithCD2 = new StereoOnWithCDCommand(stereo2);
		StereoOffCommand stereoOff2 = new StereoOffCommand(stereo2);
		
		Command[] partyOn = { lightOn2, stereoOnWithCD2 };
		Command[] partyOff = { lightOff2, stereoOff2 };
		
		MacroCommand partyOnMacro = new MacroCommand(partyOn);
		MacroCommand partyOffMacro = new MacroCommand(partyOff);
		
		remoteControl.setCommand(0, partyOnMacro, partyOffMacro);
		
		System.out.println(remoteControl);
		System.out.println("--- Pushing Macro On---");
		remoteControl.onButtonWasPushed(0);
		
		System.out.println("--- Pushing Macro Off---");
		remoteControl.offButtonWasPushed(0);
		
		remoteControl.undoButtonWasPushed();
	}
}
