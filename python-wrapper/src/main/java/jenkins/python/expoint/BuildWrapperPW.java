package jenkins.python.expoint;


import hudson.ExtensionPoint;
import hudson.Launcher;
import hudson.DescriptorExtensionList;
import hudson.LauncherDecorator;
import hudson.console.ConsoleLogFilter;
import hudson.model.*;
import hudson.model.Run.RunnerAbortedException;
import hudson.util.ArgumentListBuilder;
import jenkins.model.Jenkins;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import hudson.tasks.*;
import hudson.tasks.BuildWrapper.*;
import hudson.model.AbstractDescribableImpl.*;
import jenkins.python.DataConvertor;
import jenkins.python.PythonExecutor;

/**
 * This class was automatically generated by the PWM tool on 2014/03/21.
 * @see hudson.tasks.BuildWrapper
 */
public abstract class BuildWrapperPW extends BuildWrapper {
	private transient PythonExecutor pexec;

	private void initPython() {
		if (pexec == null) {
			pexec = new PythonExecutor(this);
			String[] jMethods = new String[0];
			String[] pFuncs = new String[0];
			Class[][] argTypes = new Class[0][];
			pexec.checkAbstrMethods(jMethods, pFuncs, argTypes);
			String[] functions = new String[9];
			functions[0] = "set_up";
			functions[1] = "decorate_launcher";
			functions[2] = "decorate_logger";
			functions[3] = "pre_checkout";
			functions[4] = "get_project_action";
			functions[5] = "get_project_actions";
			functions[6] = "make_build_variables";
			functions[7] = "make_sensitive_build_variables";
			functions[8] = "get_descriptor";
			int[] argsCount = new int[9];
			argsCount[0] = 3;
			argsCount[1] = 3;
			argsCount[2] = 2;
			argsCount[3] = 3;
			argsCount[4] = 1;
			argsCount[5] = 1;
			argsCount[6] = 2;
			argsCount[7] = 2;
			argsCount[8] = 0;
			pexec.registerFunctions(functions, argsCount);
		}
	}

	@Override
	public Environment setUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		initPython();
		if (pexec.isImplemented(0)) {
			return (Environment) pexec.execPython("set_up", build, launcher, listener);
		} else {
			return super.setUp(build, launcher, listener);
		}
	}

	@Override
	public Launcher decorateLauncher(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException, RunnerAbortedException {
		initPython();
		if (pexec.isImplemented(1)) {
			return (Launcher) pexec.execPython("decorate_launcher", build, launcher, listener);
		} else {
			return super.decorateLauncher(build, launcher, listener);
		}
	}

	@Override
	public OutputStream decorateLogger(AbstractBuild build, OutputStream logger) throws IOException, InterruptedException, RunnerAbortedException {
		initPython();
		if (pexec.isImplemented(2)) {
			return (OutputStream) pexec.execPython("decorate_logger", build, logger);
		} else {
			return super.decorateLogger(build, logger);
		}
	}

	@Override
	public void preCheckout(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		initPython();
		if (pexec.isImplemented(3)) {
			pexec.execPythonVoid("pre_checkout", build, launcher, listener);
		} else {
			super.preCheckout(build, launcher, listener);
		}
	}

	@Override
	public Action getProjectAction(AbstractProject job) {
		initPython();
		if (pexec.isImplemented(4)) {
			return (Action) pexec.execPython("get_project_action", job);
		} else {
			return super.getProjectAction(job);
		}
	}

	@Override
	public Collection<? extends Action> getProjectActions(AbstractProject job) {
		initPython();
		if (pexec.isImplemented(5)) {
			return (Collection) pexec.execPython("get_project_actions", job);
		} else {
			return super.getProjectActions(job);
		}
	}

	@Override
	public void makeBuildVariables(AbstractBuild build, Map<String, String> variables) {
		initPython();
		if (pexec.isImplemented(6)) {
			pexec.execPythonVoid("make_build_variables", build, variables);
		} else {
			super.makeBuildVariables(build, variables);
		}
	}

	@Override
	public void makeSensitiveBuildVariables(AbstractBuild build, Set<String> sensitiveVariables) {
		initPython();
		if (pexec.isImplemented(7)) {
			pexec.execPythonVoid("make_sensitive_build_variables", build, sensitiveVariables);
		} else {
			super.makeSensitiveBuildVariables(build, sensitiveVariables);
		}
	}

	@Override
	public Descriptor<BuildWrapper> getDescriptor() {
		initPython();
		if (pexec.isImplemented(8)) {
			return (Descriptor) pexec.execPython("get_descriptor");
		} else {
			return super.getDescriptor();
		}
	}

	public Environment superSetUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		return super.setUp(build, launcher, listener);
	}

	public Launcher superDecorateLauncher(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException, RunnerAbortedException {
		return super.decorateLauncher(build, launcher, listener);
	}

	public OutputStream superDecorateLogger(AbstractBuild build, OutputStream logger) throws IOException, InterruptedException, RunnerAbortedException {
		return super.decorateLogger(build, logger);
	}

	public void superPreCheckout(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException {
		super.preCheckout(build, launcher, listener);
	}

	public Action superGetProjectAction(AbstractProject job) {
		return super.getProjectAction(job);
	}

	public Collection<? extends Action> superGetProjectActions(AbstractProject job) {
		return super.getProjectActions(job);
	}

	public void superMakeBuildVariables(AbstractBuild build, Map<String, String> variables) {
		super.makeBuildVariables(build, variables);
	}

	public void superMakeSensitiveBuildVariables(AbstractBuild build, Set<String> sensitiveVariables) {
		super.makeSensitiveBuildVariables(build, sensitiveVariables);
	}

	public Descriptor<BuildWrapper> superGetDescriptor() {
		return super.getDescriptor();
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
