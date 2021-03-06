package jenkins.python.expoint;


import hudson.EnvVars;
import hudson.ExtensionPoint;
import hudson.FilePath;
import hudson.Launcher;
import hudson.DescriptorExtensionList;
import hudson.model.Descriptor.FormException;
import hudson.model.Queue.BuildableItem;
import hudson.model.ReconfigurableDescribable;
import hudson.model.TaskListener;
import hudson.model.queue.CauseOfBlockage;
import hudson.scm.SCM;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.Environment;
import jenkins.model.Jenkins;
import hudson.model.Node;
import hudson.model.Queue.Task;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.StaplerRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import hudson.slaves.*;
import hudson.slaves.NodeProperty.*;
import jenkins.python.DataConvertor;
import jenkins.python.PythonExecutor;

/**
 * This class was automatically generated by the PWM tool on 2014/03/21.
 * @see hudson.slaves.NodeProperty
 */
public abstract class NodePropertyPW<N extends Node> extends NodeProperty<N> {
	private transient PythonExecutor pexec;

	private void initPython() {
		if (pexec == null) {
			pexec = new PythonExecutor(this);
			String[] jMethods = new String[0];
			String[] pFuncs = new String[0];
			Class[][] argTypes = new Class[0][];
			pexec.checkAbstrMethods(jMethods, pFuncs, argTypes);
			String[] functions = new String[7];
			functions[0] = "set_node";
			functions[1] = "get_descriptor";
			functions[2] = "can_take";
			functions[3] = "can_take";
			functions[4] = "set_up";
			functions[5] = "build_env_vars";
			functions[6] = "reconfigure";
			int[] argsCount = new int[7];
			argsCount[0] = 1;
			argsCount[1] = 0;
			argsCount[2] = 1;
			argsCount[3] = 1;
			argsCount[4] = 3;
			argsCount[5] = 2;
			argsCount[6] = 2;
			pexec.registerFunctions(functions, argsCount);
		}
	}

	@Override
	public void setNode(N node) {
		initPython();
		if (pexec.isImplemented(0)) {
			pexec.execPythonVoid("set_node", node);
		} else {
			super.setNode(node);
		}
	}

	@Override
	public NodePropertyDescriptor getDescriptor() {
		initPython();
		if (pexec.isImplemented(1)) {
			return (NodePropertyDescriptor) pexec.execPython("get_descriptor");
		} else {
			return super.getDescriptor();
		}
	}

	@Override
	public CauseOfBlockage canTake(Task task) {
		initPython();
		if (pexec.isImplemented(2)) {
			return (CauseOfBlockage) pexec.execPython("can_take", task);
		} else {
			return super.canTake(task);
		}
	}

	@Override
	public CauseOfBlockage canTake(BuildableItem item) {
		initPython();
		if (pexec.isImplemented(3)) {
			return (CauseOfBlockage) pexec.execPython("can_take", item);
		} else {
			return super.canTake(item);
		}
	}

	@Override
	public Environment setUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		initPython();
		if (pexec.isImplemented(4)) {
			return (Environment) pexec.execPython("set_up", build, launcher, listener);
		} else {
			return super.setUp(build, launcher, listener);
		}
	}

	@Override
	public void buildEnvVars(EnvVars env, TaskListener listener) throws IOException, InterruptedException {
		initPython();
		if (pexec.isImplemented(5)) {
			pexec.execPythonVoid("build_env_vars", env, listener);
		} else {
			super.buildEnvVars(env, listener);
		}
	}

	@Override
	public NodeProperty<?> reconfigure(StaplerRequest req, JSONObject form) throws FormException {
		initPython();
		if (pexec.isImplemented(6)) {
			return (NodeProperty) pexec.execPython("reconfigure", req, form);
		} else {
			return super.reconfigure(req, form);
		}
	}

	public void superSetNode(N node) {
		super.setNode(node);
	}

	public NodePropertyDescriptor superGetDescriptor() {
		return super.getDescriptor();
	}

	public CauseOfBlockage superCanTake(Task task) {
		return super.canTake(task);
	}

	public CauseOfBlockage superCanTake(BuildableItem item) {
		return super.canTake(item);
	}

	public Environment superSetUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		return super.setUp(build, launcher, listener);
	}

	public void superBuildEnvVars(EnvVars env, TaskListener listener) throws IOException, InterruptedException {
		super.buildEnvVars(env, listener);
	}

	public NodeProperty<?> superReconfigure(StaplerRequest req, JSONObject form) throws FormException {
		return super.reconfigure(req, form);
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
