import { useState, useEffect } from 'react'
import './App.css'

function App() {
    const [announcements, setAnnouncements] = useState([])

    // Ta funkcja uruchomi się raz po załadowaniu strony
    useEffect(() => {
        fetch('http://localhost:8080/announcements')
            .then(response => response.json())
            .then(data => setAnnouncements(data))
            .catch(error => console.error('Błąd pobierania:', error));
    }, [])

    return (
        <div className="container">
            <h1>Ogłoszenia Taneczne</h1>

            <div className="announcements-list">
                {announcements.length === 0 ? (
                    <p>Brak ogłoszeń lub ładowanie...</p>
                ) : (
                    announcements.map((announcement) => (
                        <div key={announcement.id} style={{ border: '1px solid #ccc', margin: '10px', padding: '10px', borderRadius: '8px' }}>
                            <h2>{announcement.title} <small>({announcement.type})</small></h2>
                            <p>{announcement.description}</p>
                            <small>Data: {new Date(announcement.date).toLocaleDateString()}</small>
                            {announcement.link && (
                                <p><a href={announcement.link} target="_blank" rel="noreferrer">Więcej info</a></p>
                            )}
                        </div>
                    ))
                )}
            </div>
        </div>
    )
}

export default App