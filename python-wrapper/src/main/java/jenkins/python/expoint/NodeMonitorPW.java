package jenkins.python.expoint;


import hudson.ExtensionPoint;
import hudson.DescriptorExtensionList;
import hudson.Extension;
import hudson.tasks.Publisher;
import hudson.model.Computer;
import hudson.model.ComputerSet;
import hudson.model.Describable;
import hudson.model.Node;
import jenkins.model.Jenkins;
import hudson.model.Descriptor;
import hudson.util.DescriptorList;
import java.util.List;
import org.kohsuke.stapler.export.Exported;
import org.kohsuke.stapler.export.ExportedBean;
import hudson.node_monitors.*;
import hudson.node_monitors.NodeMonitor.*;
import jenkins.python.DataConvertor;
import jenkins.python.PythonExecutor;

/**
 * This class was automatically generated by the PWM tool on 2014/03/21.
 * @see hudson.node_monitors.NodeMonitor
 */
public abstract class NodeMonitorPW extends NodeMonitor {
	private transient PythonExecutor pexec;

	private void initPython() {
		if (pexec == null) {
			pexec = new PythonExecutor(this);
			String[] jMethods = new String[0];
			String[] pFuncs = new String[0];
			Class[][] argTypes = new Class[0][];
			pexec.checkAbstrMethods(jMethods, pFuncs, argTypes);
			String[] functions = new String[6];
			functions[0] = "get_column_caption";
			functions[1] = "get_descriptor";
			functions[2] = "data";
			functions[3] = "trigger_update";
			functions[4] = "is_ignored";
			functions[5] = "set_ignored";
			int[] argsCount = new int[6];
			argsCount[0] = 0;
			argsCount[1] = 0;
			argsCount[2] = 1;
			argsCount[3] = 0;
			argsCount[4] = 0;
			argsCount[5] = 1;
			pexec.registerFunctions(functions, argsCount);
		}
	}

	@Override
	@Exported
	public String getColumnCaption() {
		initPython();
		if (pexec.isImplemented(0)) {
			return (String) pexec.execPython("get_column_caption");
		} else {
			return super.getColumnCaption();
		}
	}

	@Override
	public AbstractNodeMonitorDescriptor<?> getDescriptor() {
		initPython();
		if (pexec.isImplemented(1)) {
			return (AbstractNodeMonitorDescriptor) pexec.execPython("get_descriptor");
		} else {
			return super.getDescriptor();
		}
	}

	@Override
	public Object data(Computer c) {
		initPython();
		if (pexec.isImplemented(2)) {
			return (Object) pexec.execPython("data", c);
		} else {
			return super.data(c);
		}
	}

	@Override
	public Thread triggerUpdate() {
		initPython();
		if (pexec.isImplemented(3)) {
			return (Thread) pexec.execPython("trigger_update");
		} else {
			return super.triggerUpdate();
		}
	}

	@Override
	public boolean isIgnored() {
		initPython();
		if (pexec.isImplemented(4)) {
			return pexec.execPythonBool("is_ignored");
		} else {
			return super.isIgnored();
		}
	}

	@Override
	public void setIgnored(boolean ignored) {
		initPython();
		if (pexec.isImplemented(5)) {
			pexec.execPythonVoid("set_ignored", DataConvertor.fromBool(ignored));
		} else {
			super.setIgnored(ignored);
		}
	}

	public String superGetColumnCaption() {
		return super.getColumnCaption();
	}

	public AbstractNodeMonitorDescriptor<?> superGetDescriptor() {
		return super.getDescriptor();
	}

	public Object superData(Computer c) {
		return super.data(c);
	}

	public Thread superTriggerUpdate() {
		return super.triggerUpdate();
	}

	public boolean superIsIgnored() {
		return super.isIgnored();
	}

	public void superSetIgnored(boolean ignored) {
		super.setIgnored(ignored);
	}

	public Object execPython(String function, Object... params) {
		initPython();
		return pexec.execPython(function, params);
	}

	public byte execPythonByte(String function, Object... params) {
		initPython();
		return pexec.execPythonByte(function, params);
	}

	public short execPythonShort(String function, Object... params) {
		initPython();
		return pexec.execPythonShort(function, params);
	}

	public char execPythonChar(String function, Object... params) {
		initPython();
		return pexec.execPythonChar(function, params);
	}

	public int execPythonInt(String function, Object... params) {
		initPython();
		return pexec.execPythonInt(function, params);
	}

	public long execPythonLong(String function, Object... params) {
		initPython();
		return pexec.execPythonLong(function, params);
	}

	public float execPythonFloat(String function, Object... params) {
		initPython();
		return pexec.execPythonFloat(function, params);
	}

	public double execPythonDouble(String function, Object... params) {
		initPython();
		return pexec.execPythonDouble(function, params);
	}

	public boolean execPythonBool(String function, Object... params) {
		initPython();
		return pexec.execPythonBool(function, params);
	}

	public void execPythonVoid(String function, Object... params) {
		initPython();
		pexec.execPythonVoid(function, params);
	}
}