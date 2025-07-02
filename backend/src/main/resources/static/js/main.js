const apiUrl = "http://localhost:8080/jobs";

// Load jobs on page load
window.onload = () => loadJobs();

document.getElementById("jobForm").addEventListener("submit", async (e) => {
    e.preventDefault();

    const job = {
        description: document.getElementById("description").value,
        company: document.getElementById("company").value,
        yearsOfExperience: parseInt(document.getElementById("yearsOfExperience").value)
    };

    const res = await fetch(apiUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(job)
    });

    if (res.ok) {
        alert("Job added successfully.");
        document.getElementById("jobForm").reset();
        loadJobs();
    } else {
        alert("Failed to add job.");
    }
});

async function loadJobs() {
    const res = await fetch(apiUrl);
    const jobs = await res.json();

    const jobList = document.getElementById("jobList");
    jobList.innerHTML = "";

    jobs.forEach(job => {
        const li = document.createElement("li");
        li.innerHTML = `
            <strong>${job.description}</strong> at ${job.company} (${job.yearsOfExperience} yrs)
            <button class="delete-btn" onclick="deleteJob(${job.id})">Delete</button>
        `;
        jobList.appendChild(li);
    });
}

async function deleteJob(id) {
    const res = await fetch(`${apiUrl}/${id}`, {
        method: "DELETE"
    });

    if (res.ok) {
        loadJobs();
    } else {
        alert("Failed to delete job.");
    }
}
