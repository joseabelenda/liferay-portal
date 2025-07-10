/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

import React from 'react';
import {createRoot} from 'react-dom/client';

import HelloBar from './routes/hello-bar/pages/HelloBar.js';
import HelloFoo from './routes/hello-foo/pages/HelloFoo.js';
import HelloWorld from './routes/hello-world/pages/HelloWorld.js';
import ComponentA from './common/components/ComponentA.js'
import ComponentB from './common/components/ComponentB.js'
import ComponentC from './common/components/ComponentC.js'

const App = ({route}) => {
	if (route === 'hello-bar') {
		return <HelloBar />;
	}

	if (route === 'hello-foo') {
		return <HelloFoo />;
	}

	return (
		<div>
			<HelloWorld />
		</div>
	);
};

class WebComponent1 extends HTMLElement {
	connectedCallback() {
		this.root = createRoot(this);

		this.root.render(<App route={this.getAttribute('route')} />, this);
	}

	disconnectedCallback() {
		this.root.unmount();

		delete this.root;
	}
}

class WebComponent2 extends HTMLElement {
	connectedCallback() {
		this.root = createRoot(this);

		this.root.render(<ComponentA />, this);
	}

	disconnectedCallback() {
		this.root.unmount();

		delete this.root;
	}
}

class WebComponent3 extends HTMLElement {
	connectedCallback() {
		this.root = createRoot(this);

		this.root.render(<ComponentB />, this);
	}

	disconnectedCallback() {
		this.root.unmount();

		delete this.root;
	}
}

class WebComponent4 extends HTMLElement {
	connectedCallback() {
		this.root = createRoot(this);

		this.root.render(<ComponentC />, this);
	}

	disconnectedCallback() {
		this.root.unmount();

		delete this.root;
	}
}

const WEB_COMPONENT_1 = 'liferay-sample-custom-element-1';
const WEB_COMPONENT_2 = 'liferay-sample-custom-element-2';
const WEB_COMPONENT_3 = 'liferay-sample-custom-element-3';
const WEB_COMPONENT_4 = 'liferay-sample-custom-element-4';

if (!customElements.get(WEB_COMPONENT_1)) {
	customElements.define(WEB_COMPONENT_1, WebComponent1);
}

if (!customElements.get(WEB_COMPONENT_2)) {
	customElements.define(WEB_COMPONENT_2, WebComponent2);
}

if (!customElements.get(WEB_COMPONENT_3)) {
	customElements.define(WEB_COMPONENT_3, WebComponent3);
}

if (!customElements.get(WEB_COMPONENT_4)) {
	customElements.define(WEB_COMPONENT_4, WebComponent4);
}